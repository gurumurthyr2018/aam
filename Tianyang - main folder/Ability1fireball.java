import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class FireballEntity extends ProjectileItemEntity {
    public FireballEntity(EntityType<? extends ProjectileItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public FireballEntity(World world, LivingEntity thrower, Item item) {
        super(EntityType.FIREBALL, thrower, world);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        // Create explosion
        float explosionPower = 5.0f;  // Adjust explosion power here
        World world = this.world;
        if (!world.isRemote) {
            if (result.getType() == RayTraceResult.Type.BLOCK) {
                BlockPos pos = result.getBlockPos();
                world.createExplosion(this, pos.getX(), pos.getY(), pos.getZ(), explosionPower, true, false);
            } else if (result.getType() == RayTraceResult.Type.ENTITY) {
                result.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), explosionPower);
                world.createExplosion(this, result.getEntity().getPosX(), result.getEntity().getPosY(), result.getEntity().getPosZ(), explosionPower, true, true);
            }
        }
        // Remove fireball entity
        this.remove();
    }
}