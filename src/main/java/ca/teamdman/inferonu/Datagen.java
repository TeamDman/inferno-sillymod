package ca.teamdman.inferonu;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.loading.DatagenModLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import java.io.IOException;

@Mod.EventBusSubscriber(modid = InfernoU.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Datagen {
	@SubscribeEvent
	public static void onGather(GatherDataEvent event) {
		if (!DatagenModLoader.isRunningDataGen()) return;
		var gen = event.getGenerator();
		if (event.includeServer()) {
			gen.addProvider(new BlockStates(gen, event.getExistingFileHelper()));
			gen.addProvider(new ItemModels(gen, event.getExistingFileHelper()));
			//			gen.addProvider(event.includeClient(), new SFMBlockTags(gen, event.getExistingFileHelper()));
			//			gen.addProvider(event.includeClient(), new SFMLootTables(gen));
			//			gen.addProvider(event.includeClient(), new SFMRecipes(gen));
		}
	}

	private static class BlockStates extends BlockStateProvider {
		public BlockStates(DataGenerator gen, ExistingFileHelper existingFileHelper) {
			super(gen, InfernoU.MOD_ID, existingFileHelper);
		}

		@Override
		protected void registerStatesAndModels() {
			simpleBlock(InfernoU.Registry.UNI_1_BLOCK.get());
			simpleBlock(InfernoU.Registry.UNI_2_BLOCK.get());
			simpleBlock(InfernoU.Registry.UNI_3_BLOCK.get());
			simpleBlock(InfernoU.Registry.UNI_4_BLOCK.get());
		}
	}

	private static class ItemModels extends ItemModelProvider {
		public ItemModels(DataGenerator gen, ExistingFileHelper existingFileHelper) {
			super(gen, InfernoU.MOD_ID, existingFileHelper);
		}

		@Override
		protected void registerModels() {
			withExistingParent(InfernoU.Registry.UNI_1_BLOCK.getId()
									   .getPath(),
							   InfernoU.MOD_ID + ":block/" + InfernoU.Registry.UNI_1_ITEM.getId()
									   .getPath());

			withExistingParent(InfernoU.Registry.UNI_2_BLOCK.getId()
									   .getPath(),
							   InfernoU.MOD_ID + ":block/" + InfernoU.Registry.UNI_2_ITEM.getId()
									   .getPath());

			withExistingParent(InfernoU.Registry.UNI_3_BLOCK.getId()
									   .getPath(),
							   InfernoU.MOD_ID + ":block/" + InfernoU.Registry.UNI_3_ITEM.getId()
									   .getPath());

			withExistingParent(InfernoU.Registry.UNI_4_BLOCK.getId()
									   .getPath(),
							   InfernoU.MOD_ID + ":block/" + InfernoU.Registry.UNI_4_ITEM.getId()
									   .getPath());
		}
	}
}
