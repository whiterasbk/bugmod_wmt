package mod.whiter.template.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.resources.IResourceManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import static mod.whiter.template.App.LOGGER;
import static mod.whiter.template.locale.Local.localname;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {

    static Block b;

    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
        // register a new block here
        LOGGER.info("Registering Blocks");

        AbstractBlock.Properties bp = AbstractBlock.Properties.create(Material.ICE);
        bp.hardnessAndResistance(12);
        b = new Block(bp);
        b.setRegistryName(localname("inevil_block"));

        event.getRegistry().registerAll(b);


    }

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
        // register a new Items here
        LOGGER.info("Registering Items");

        Item.Properties ip1 = new Item.Properties();
        ip1.group(ItemGroup.MATERIALS);
        ip1.maxStackSize(12);
        Item i1 = new Item(ip1);
        i1.setRegistryName(localname("inevil"));

        Item.Properties ip2 = new Item.Properties();
        ip2.group(ItemGroup.MATERIALS);
        ip2.maxStackSize(12);
        Item i2 = new Item(ip2);
        i2.setRegistryName(localname("wrench"));

        Item ib = new BlockItem(b, new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(b.getRegistryName());

        event.getRegistry().register(i1);
        event.getRegistry().register(i2);
        event.getRegistry().register(ib);

    }
}