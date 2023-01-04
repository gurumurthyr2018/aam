Copy code
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModEventHandler {
    private static boolean hasOpenedWelcomeScreen = false;

    @SubscribeEvent
    public static void onGuiOpen(GuiOpenEvent event) {
        if (!hasOpenedWelcomeScreen && event.getGui() == null) {
            // Open the welcome screen on the first join
            event.setGui(new WelcomeScreen());
            hasOpenedWelcomeScreen = true;
        }
    }

    public static class WelcomeScreen extends Screen {
        public WelcomeScreen() {
            super(new StringTextComponent("Welcome to the Mod"));
        }

        @Override
        public void init() {
            // Add the "The Wild" button
            this.addButton(new Button(this.width / 2 - 100, this.height / 4 + 24, 200, 20, "The Wild", (button) -> {
                // Handle button click here
            }));

            // Add the "Fire" button
            this.addButton(new Button(this.width / 2 - 100, this.height / 4 + 48, 200, 20, "Fire", (button) -> {
                // Handle button click here
            }));

            // Add the "Genocide" button
            this.addButton(new Button(this.width / 2 - 100, this.height / 4 + 72, 200, 20, "Genocide", (button) -> {
                // Handle button click here
            }));

            // Add the "Error" button
            this.addButton(new Button(this.width / 2 - 100, this.height / 4 + 96, 200, 20, "Error", (button) -> {
                // Handle button click here
            }));
        }

        @Override
        public void render(int mouseX, int mouseY, float partialTicks) {
            this.renderBackground();
            this.drawCenteredString(this.font, this.title.getFormattedText(), this.width / 2, this.height / 4 - 60, 0xFFFFFF);
            super.render(mouseX, mouseY, partialTicks);
        }
    }
}