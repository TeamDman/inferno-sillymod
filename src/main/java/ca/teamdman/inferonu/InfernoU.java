package ca.teamdman.inferonu;

import ca.teamdman.inferonu.blocks.Uni1;
import ca.teamdman.inferonu.blocks.Uni2;
import ca.teamdman.inferonu.blocks.Uni3;
import ca.teamdman.inferonu.blocks.Uni4;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(InfernoU.MOD_ID)
public class InfernoU {
	public static final  String MOD_ID = "infernou";
	// Directly reference a slf4j logger
	private static final Logger LOGGER = LogUtils.getLogger();

	public InfernoU() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();
		Registry.BLOCKS.register(bus);
		Registry.ITEMS.register(bus);
	}

	// You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
	// Event bus for receiving Registry Events)
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class Registry {
		public static final DeferredRegister<Block> BLOCKS      = DeferredRegister.create(ForgeRegistries.BLOCKS, InfernoU.MOD_ID);
		public static final DeferredRegister<Item>  ITEMS      = DeferredRegister.create(ForgeRegistries.ITEMS, InfernoU.MOD_ID);
		public static final RegistryObject<Block>   UNI_1_BLOCK = BLOCKS.register("uni1", Uni1::new);
        public static final RegistryObject<Item> UNI_1_ITEM = registerItem("uni1", UNI_1_BLOCK);
		public static final RegistryObject<Block>   UNI_2_BLOCK = BLOCKS.register("uni2", Uni2::new);
        public static final RegistryObject<Item> UNI_2_ITEM = registerItem("uni2", UNI_2_BLOCK);
		public static final RegistryObject<Block>   UNI_3_BLOCK = BLOCKS.register("uni3", Uni3::new);
        public static final RegistryObject<Item> UNI_3_ITEM = registerItem("uni3", UNI_3_BLOCK);
		public static final RegistryObject<Block>   UNI_4_BLOCK = BLOCKS.register("uni4", Uni4::new);
        public static final RegistryObject<Item> UNI_4_ITEM = registerItem("uni4", UNI_4_BLOCK);


        public static final CreativeModeTab TAB = new CreativeModeTab(MOD_ID) {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(UNI_1_ITEM.get());
            }
        };

        private static RegistryObject<Item> registerItem(String name, RegistryObject<Block> block) {
            return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(TAB)));
        }
	}


}
