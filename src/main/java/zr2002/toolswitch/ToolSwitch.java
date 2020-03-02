package com.zr2002.ToolSwitch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("toolswitch")
public class ToolSwitch {

	public static ToolSwitch instance;
	public static final String modid = "toolswitch";
	private static final Logger logger = LogManager.getLogger(modid);

	public ToolSwitch() {

		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(EventRegister.class);

	}

	private void setup(final FMLCommonSetupEvent event) {

		logger.info("Initializing " + modid + "...");

	}

	private void clientRegistries(final FMLClientSetupEvent event) {
	}

}
