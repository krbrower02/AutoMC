package my.krbmod.automc.eventhandler;

import java.util.EnumMap;
import java.util.Map;

import my.krbmod.automc.eventhandler.MFEventHandlerTerrainGen.MFEventID;
import my.krbmod.automc.utility.LogHelper;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DeferredBiomeDecorator;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.InitNoiseGensEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MFEventHandlerOreGen {

	public static String handlerName = "Ore Gen Event Handler";
	public static boolean eventCounting = true;
	public static boolean eventLogging = true;
	public static MFEventID currentEventId;

	public static EnumMap<MFEventID, MFEvent> localEvents = new EnumMap<MFEventID, MFEvent>(MFEventID.class);

	protected enum MFEventID {
		//OREGEN_EVENT  - do not subscribe to parent event 
		OREGEN_EVENT_GENERATEMINABLE, OREGEN_EVENT_POST, OREGEN_EVENT_PRE

	}

	public static void logEventCounts() {
		if (eventCounting) {
			LogHelper.info(String.format(handlerName+" : %d elements",localEvents.size()));
			for (Map.Entry<MFEventID, MFEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}

		}

	}

	public MFEventHandlerOreGen() {
		LogHelper.info(handlerName+" has been setup");
		localEvents.put(MFEventID.OREGEN_EVENT_GENERATEMINABLE, new MFEvent("TerrainGen: Ore Gen Event - Generate Minable", true));
		localEvents.put(MFEventID.OREGEN_EVENT_POST, new MFEvent("TerrainGen: Ore Gen Event - Post", true));
		localEvents.put(MFEventID.OREGEN_EVENT_PRE, new MFEvent("TerrainGen: Ore Gen Event - Pre", true));
		
	}

	/*
	 * OreGenEvent is fired when an event involving ore generation occurs. If a
	 * method utilizes this Event as its parameter, the method will receive
	 * every child event of this class.
	 * 
	 * OreGenEvent.world contains the world this event is occurring in.
	 * 
	 * OreGenEvent.rand contains an instance of random that can be used in this
	 * event.
	 * 
	 * OreGenEvent.pos contains the coordinates of the chunk position currently
	 * being populated with ores.
	 * 
	 * All children of this event are fired on the MinecraftForge#ORE_GEN_BUS.
	 * 
	*/

	/*
	 * GenerateMinable is fired when a mineable block is generated in a chunk.
	 * This event is fired just after ore generation in
	 * BiomeDecorator#generateOres().
	 * 
	 * OreGenEvent.GenerateMinable.type contains the enum value for the Ore
	 * attempting to be generated.
	 * 
	 * OreGenEvent.GenerateMinable.generator contains the WorldGenerator
	 * generating this ore.
	 * 
	 */
	@SubscribeEvent
	public void oreGenEventGenerateMinable(OreGenEvent.GenerateMinable event) {
		currentEventId = MFEventID.OREGEN_EVENT_GENERATEMINABLE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * OreGenEvent.Post is fired just after a chunk is populated with ores. This
	 * event is fired just after ore generation in
	 * BiomeDecorator#generateOres().
	 * 
	 * This event is not Cancelable.
	 * 
	 * This event does not have a result.
	 * 
	 */
	@SubscribeEvent
	public void oreGenEventPost(OreGenEvent.Post event) {
		currentEventId = MFEventID.OREGEN_EVENT_POST;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * OreGenEvent.Pre is fired just before a chunk is populated with ores. This
	 * event is fired just before ore generation in
	 * BiomeDecorator#generateOres().
	 * 
	 * This event is not Cancelable.
	 * 
	 * This event does not have a result.
	 * 
	 */
	@SubscribeEvent
	public void oreGenEventPre(OreGenEvent.Pre event) {
		currentEventId = MFEventID.OREGEN_EVENT_PRE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	}
