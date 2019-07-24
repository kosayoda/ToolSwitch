package zr2002.toolswitch;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventRegister {
	
	private static String currentBlock;
	private static boolean toggle = false;
	private static int fortune = 8;
	private static int silk = 0;
	private static int shovel = 1;
	private static Minecraft mc = Minecraft.getInstance();
	
	public EventRegister() {
		
		
	}
	
	
	@SubscribeEvent
	public static void onSendChat(ClientChatEvent event) {
		String message = event.getMessage().toLowerCase();
		if(message.equals("/toolswitch-toggle")) {
			if(toggle) {
				toggle = false;
				mc.player.sendMessage(new StringTextComponent("�4ToolSwitch Disabled!"));
			}
			else {
				toggle = true;
				mc.player.sendMessage(new StringTextComponent("�4ToolSwitch Enabled!"));
			}
		}
		
		if(message.contains("/toolswitch-set silk ")) {
			if(message.substring(21).equals("1") || message.substring(21).equals("2") || message.substring(21).equals("3") || message.substring(21).equals("4") || message.substring(21).equals("5") || message.substring(21).equals("6") || message.substring(21).equals("7") || message.substring(21).equals("8") || message.substring(21).equals("9")) {
				silk = Integer.parseInt(message.substring(21))-1;
				mc.player.sendMessage(new StringTextComponent("�4Silk pickaxe slot set to slot #" + (silk+1) + "!"));
			}
		}
		
		if(message.contains("/toolswitch-set fortune ")) {
			if(message.substring(24).equals("1") || message.substring(24).equals("2") || message.substring(24).equals("3") || message.substring(24).equals("4") || message.substring(24).equals("5") || message.substring(24).equals("6") || message.substring(24).equals("7") || message.substring(24).equals("8") || message.substring(24).equals("9")) {
				fortune = Integer.parseInt(message.substring(24))-1;
				mc.player.sendMessage(new StringTextComponent("�4Fortune pickaxe slot set to slot #" + (fortune+1) + "!"));
			}
		}
		
		if(message.contains("/toolswitch-set shovel ")) {
			if(message.substring(23).equals("1") || message.substring(23).equals("2") || message.substring(23).equals("3") || message.substring(23).equals("4") || message.substring(23).equals("5") || message.substring(23).equals("6") || message.substring(23).equals("7") || message.substring(23).equals("8") || message.substring(23).equals("9")) {
				shovel = Integer.parseInt(message.substring(23))-1;
				mc.player.sendMessage(new StringTextComponent("�4Shovel slot set to slot #" + (shovel+1) + "!"));
			}
		}
		
		
		
	}
	
	@SubscribeEvent
	public static void onHighlight(DrawBlockHighlightEvent event) {
		
		
		RayTraceResult ray = Minecraft.getInstance().getRenderViewEntity().func_213324_a(20.0D, 0.0F, false);
		
		  if (ray.getType() == RayTraceResult.Type.BLOCK) {
	            BlockPos blockpos = ((BlockRayTraceResult)ray).getPos();
	            BlockState blockstate = Minecraft.getInstance().world.getBlockState(blockpos);
	            
	            currentBlock = String.valueOf((Object)Registry.BLOCK.getKey(blockstate.getBlock()));
	            
	            	if(currentBlock.contains("stone") && toggle) {
	            	Minecraft.getInstance().player.inventory.currentItem = silk;
	            	}
	            	if(currentBlock.contains("diorite") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = silk;
		            	}
	            	if(currentBlock.contains("granite") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = silk;
		            	}
	            	if(currentBlock.contains("diorite") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = silk;
		            	}
	            	if(currentBlock.contains("andesite") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = silk;
		            	}
	            	if(currentBlock.contains("sandstone") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = silk;
		            	}
	            	if(currentBlock.contains("obsidian") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = silk;
		            	}
	            	if(currentBlock.contains("netherrack") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = silk;
	            	}
	            	if(currentBlock.contains("gold") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = silk;
		            	}
	            	if(currentBlock.contains("iron") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = silk;
		            	}
	            	if(currentBlock.contains("brick") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = silk;
		            	}
	            	if(currentBlock.contains("diamond") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = fortune;
		            	}
	            	if(currentBlock.contains("redstone") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = fortune;
		            	}
	            	if(currentBlock.contains("lapis") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = fortune;
		            	}
	            	if(currentBlock.contains("coal") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = fortune;
		            	}
	            	if(currentBlock.contains("quartz_ore") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = fortune;
		            	}
	            	if(currentBlock.contains("dirt") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = shovel;
		            	}
	            	if(currentBlock.contains("grass") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = shovel;
		            	}
	            	if(currentBlock.contains("gravel") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = shovel;
		            	}
	            	if(currentBlock.contains("sponge") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = shovel;
		            	}
	            	if(currentBlock.contains("clay") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = shovel;
		            	}
	            	if(currentBlock.contains("sand") && !currentBlock.contains("sandstone") && toggle) {
		            	Minecraft.getInstance().player.inventory.currentItem = shovel;
		            	}
	            	
	            
	            
	}
	
	}

}