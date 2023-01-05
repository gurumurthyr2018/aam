import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "mymod");
    
    public static final RegistryObject<Item> ERROR_SWORD = ITEMS.register("error_sword", ErrorSword::new);
}
public class ErrorSword extends SwordItem {
    public ErrorSword() {
        super(ItemTier.DIAMOND, 45, 2.0f, new Item.Properties()
            .maxStackSize(1)
            .setNoRepair()
            .setUndroppable()
            .setUnbreakable());
    }
    
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }
}