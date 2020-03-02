package com.zr2002.ToolSwitch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.DrawHighlightEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventRegister {
	
	private static String currentBlock;
	private static boolean toggle = false;
	private static int fortune = 8;
	private static int silk = 0;
	private static int shovel = 1;
	private static int axe = 2;
	private static int shears = 3;
	private static Minecraft mc = Minecraft.getInstance();
	private static boolean isFluid;
	private static String currentFluid;
	private static final Logger logger = LogManager.getLogger();
	
	public EventRegister() {
		
		
	}
	
	
	@SubscribeEvent
	public static void onSendChat(ClientChatEvent event) {
		String message = event.getMessage().toLowerCase();
		if(message.equals("/toolswitch-toggle")) {
			event.setCanceled(true);
			if(toggle) {
				toggle = false;
				mc.player.sendMessage(new StringTextComponent("§4ToolSwitch Disabled!"));
			}
			else {
				toggle = true;
				mc.player.sendMessage(new StringTextComponent("§4ToolSwitch Enabled!"));
			}
		}
		
		if(message.contains("/toolswitch-set silk ")) {
			event.setCanceled(true);
			if(message.substring(21).equals("1") || message.substring(21).equals("2") || message.substring(21).equals("3") || message.substring(21).equals("4") || message.substring(21).equals("5") || message.substring(21).equals("6") || message.substring(21).equals("7") || message.substring(21).equals("8") || message.substring(21).equals("9")) {
				silk = Integer.parseInt(message.substring(21))-1;
				mc.player.sendMessage(new StringTextComponent("§4Silk pickaxe slot set to slot #" + (silk+1) + "!"));
			}
		}
		
		if(message.contains("/toolswitch-set fortune ")) {
			event.setCanceled(true);
			if(message.substring(24).equals("1") || message.substring(24).equals("2") || message.substring(24).equals("3") || message.substring(24).equals("4") || message.substring(24).equals("5") || message.substring(24).equals("6") || message.substring(24).equals("7") || message.substring(24).equals("8") || message.substring(24).equals("9")) {
				fortune = Integer.parseInt(message.substring(24))-1;
				mc.player.sendMessage(new StringTextComponent("§4Fortune pickaxe slot set to slot #" + (fortune+1) + "!"));
			}
		}
		
		if(message.contains("/toolswitch-set shovel ")) {
			event.setCanceled(true);
			if(message.substring(23).equals("1") || message.substring(23).equals("2") || message.substring(23).equals("3") || message.substring(23).equals("4") || message.substring(23).equals("5") || message.substring(23).equals("6") || message.substring(23).equals("7") || message.substring(23).equals("8") || message.substring(23).equals("9")) {
				shovel = Integer.parseInt(message.substring(23))-1;
				mc.player.sendMessage(new StringTextComponent("§4Shovel slot set to slot #" + (shovel+1) + "!"));
			}
		}
		
		if(message.contains("/toolswitch-set axe ")) {
			event.setCanceled(true);
			if(message.substring(20).equals("1") || message.substring(20).equals("2") || message.substring(20).equals("3") || message.substring(20).equals("4") || message.substring(20).equals("5") || message.substring(20).equals("6") || message.substring(20).equals("7") || message.substring(20).equals("8") || message.substring(20).equals("9")) {
				shovel = Integer.parseInt(message.substring(20))-1;
				mc.player.sendMessage(new StringTextComponent("§4Axe slot set to slot #" + (axe+1) + "!"));
			
			}
		
		}
		
		if(message.contains("/toolswitch-set shears ")) {
			event.setCanceled(true);
			if(message.substring(23).equals("1") || message.substring(23).equals("2") || message.substring(23).equals("3") || message.substring(23).equals("4") || message.substring(23).equals("5") || message.substring(23).equals("6") || message.substring(23).equals("7") || message.substring(23).equals("8") || message.substring(23).equals("9")) {
				axe = Integer.parseInt(message.substring(23))-1;
				mc.player.sendMessage(new StringTextComponent("§4Shears slot set to slot #" + (shears+1) + "!"));
			}
		}
		
	}
	
	@SubscribeEvent
	public static void onHighlight(DrawHighlightEvent event) {
		
		
		RayTraceResult ray = Minecraft.getInstance().getRenderViewEntity().func_213324_a(6.0D, 0.0F, false);
		RayTraceResult fluid = Minecraft.getInstance().getRenderViewEntity().func_213324_a(6.0D, 0.0F, true);
		if(fluid.getType() == RayTraceResult.Type.BLOCK) {
			BlockPos fluidpos = ((BlockRayTraceResult)fluid).getPos();
			BlockState fluidstate = Minecraft.getInstance().world.getBlockState(fluidpos);
			currentFluid = String.valueOf((Object)Registry.BLOCK.getKey(fluidstate.getBlock()));
			if(currentFluid.contains("water") || currentFluid.contains("lava")) {
				isFluid = true;
			}
			else isFluid = false;
		}
		
		
		
		  if (ray.getType() == RayTraceResult.Type.BLOCK) {
	            BlockPos blockpos = ((BlockRayTraceResult)ray).getPos();
	            BlockState blockstate = Minecraft.getInstance().world.getBlockState(blockpos);
	            
	            currentBlock = String.valueOf((Object)Registry.BLOCK.getKey(blockstate.getBlock()));
	            if(!isFluid) {
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
	            	if(currentBlock.contains("emerald") && toggle) {
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
	            	if(currentBlock.contains("log") && toggle) {
	            		Minecraft.getInstance().player.inventory.currentItem = axe;
	            	}
	            	
	            	if(currentBlock.contains("wood") && toggle) {
	            		Minecraft.getInstance().player.inventory.currentItem = axe;
	            	}
	            	
	            	if(currentBlock.contains("plank") && toggle) {
	            		Minecraft.getInstance().player.inventory.currentItem = axe;
	            	}
	            	
	            	if(currentBlock.contains("chest") && toggle) {
	            		Minecraft.getInstance().player.inventory.currentItem = axe;
	            	}
	            	
	            	if(currentBlock.contains("leaves") && toggle) {
	            		Minecraft.getInstance().player.inventory.currentItem = shears;
	            	}
	            	if(currentBlock.contains("wool") && toggle) {
	            		Minecraft.getInstance().player.inventory.currentItem = shears;
	            	}
	            	
	            }
	            
	}
	
	}

}
