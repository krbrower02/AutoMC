package my.krbmod.automc.eventhandler;

import java.util.EnumMap;
import java.util.Map;
import my.krbmod.automc.utility.LogHelper;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DeferredBiomeDecorator;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.InitNoiseGensEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MFEventHandlerTerrainGen {

	public static String handlerName = "Terrain Gen Event Handler";
	public static boolean eventCounting = true;
	public static boolean eventLogging = true;
	//public static MFEventID currentEventId;

	public static EnumMap<MFEventID, MFEvent> localEvents = new EnumMap<MFEventID, MFEvent>(MFEventID.class);

	protected enum MFEventID {
		//BIOME_EVENT - do not subscribe to parent event 
		BIOME_EVENT_BIOMECOLOR, BIOME_EVENT_CREATEDECORATOR, BIOME_EVENT_GETFOLIAGECOLOR, BIOME_EVENT_GETGRASSCOLOR, BIOME_EVENT_GETVILLAGEBLOCKID, BIOME_EVENT_GETWATERCOLOR, 
		//CHUNKPROVIDER_EVENT - do not subscribe to parent event 
		CHUNKPROVIDER_EVENT_INITNOISEFIELD, CHUNKPROVIDER_EVENT_REPLACEBIOMEBLOCKS, 
		//DECORATEBIOME_EVENT - do not subscribe to parent event 
		DECORATEBIOME_EVENT_DECORATE, DECORATEBIOME_EVENT_POST, DECORATEBIOME_EVENT_PRE, 
		//DEFERREDBIOMEDECORATOR - do not subscribe to parent event 
		INITMAPGEN_EVENT, INITNOISEGENS_EVENT, 
		//POPULATECHUNK_EVENT - do not subscribe to parent event 
		POPULATECHUNK_EVENT_POPULATE, POPULATECHUNK_EVENT_POST, POPULATECHUNK_EVENT_PRE, SAPLINGGROWTREEEVENT, 
		//TERRAINGEN - do not subscribe to parent event 
		//WORLDTYPEEVENT - do not subscribe to parent event 
		WORLDTYPEEVENT_BIOMESIZE, WORLDTYPEEVENT_INITBIOMEGENS

	}

	public static void logEventCounts() {
		if (eventCounting) {
			LogHelper.info(String.format(handlerName+" : %d elements",localEvents.size()));
			for (Map.Entry<MFEventID, MFEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}

		}

	}

	public MFEventHandlerTerrainGen() {
		LogHelper.info(handlerName+" has been setup");
		localEvents.put(MFEventID.BIOME_EVENT_BIOMECOLOR, new MFEvent("TerrainGen: Biome Event - Biome Color", true));
		localEvents.put(MFEventID.BIOME_EVENT_CREATEDECORATOR, new MFEvent("TerrainGen: Biome Event - Create Decorator", true));
		localEvents.put(MFEventID.BIOME_EVENT_GETFOLIAGECOLOR, new MFEvent("TerrainGen: Biome Event - Get Foliage Color", true));
		localEvents.put(MFEventID.BIOME_EVENT_GETGRASSCOLOR, new MFEvent("TerrainGen: Biome Event - Get Grass Color", true));
		localEvents.put(MFEventID.BIOME_EVENT_GETVILLAGEBLOCKID,
				new MFEvent("TerrainGen: Biome Event - Get Village Block ID", true));
		localEvents.put(MFEventID.BIOME_EVENT_GETWATERCOLOR, new MFEvent("TerrainGen: Biome Event - Get Water Color", false));
		localEvents.put(MFEventID.CHUNKPROVIDER_EVENT_INITNOISEFIELD,
				new MFEvent("TerrainGen: Chunk Provider Event - Init Noise Field", true));
		localEvents.put(MFEventID.CHUNKPROVIDER_EVENT_REPLACEBIOMEBLOCKS,
				new MFEvent("TerrainGen: Chunk Provider Event - Replace Biome Blocks", true));
		localEvents.put(MFEventID.DECORATEBIOME_EVENT_DECORATE, new MFEvent("TerrainGen: Decorate Biome Event - Decorate", true));
		localEvents.put(MFEventID.DECORATEBIOME_EVENT_POST, new MFEvent("TerrainGen: Decorate Biome Event - Post", true));
		localEvents.put(MFEventID.DECORATEBIOME_EVENT_PRE, new MFEvent("TerrainGen: Decorate Biome Event - Pre", true));
		localEvents.put(MFEventID.INITMAPGEN_EVENT, new MFEvent("TerrainGen: Init Map Gen Event", false));
		localEvents.put(MFEventID.INITNOISEGENS_EVENT, new MFEvent("TerrainGen: Init Noise Gens Event", true));
		localEvents.put(MFEventID.POPULATECHUNK_EVENT_POPULATE, new MFEvent("TerrainGen: Populate Chunk Event - Populate", true));
		localEvents.put(MFEventID.POPULATECHUNK_EVENT_POST, new MFEvent("TerrainGen: Populate Chunk Event - Post", true));
		localEvents.put(MFEventID.POPULATECHUNK_EVENT_PRE, new MFEvent("TerrainGen: Populate Chunk Event - Pre", true));
		localEvents.put(MFEventID.SAPLINGGROWTREEEVENT, new MFEvent("TerrainGen: SaplingGrowTree Event", true));
		localEvents.put(MFEventID.WORLDTYPEEVENT_BIOMESIZE, new MFEvent("TerrainGen: World Type Event - Biome Size", true));
		localEvents.put(MFEventID.WORLDTYPEEVENT_INITBIOMEGENS,
				new MFEvent("TerrainGen: World Type Event - Init Biome Gens", true));
	}

	/*
	 * BiomeEvent is fired whenever an event involving biomes occurs. If a
	 * method utilizes this Event as its parameter, the method will receive
	 * every child event of this class.
	 * 
	 * All children of this event are fired on the
	 * MinecraftForge#TERRAIN_GEN_BUS.
	 * 
	*/
	
	/*
	 * BiomeColor is fired whenever an event involving biome colors occurs.
	 * 
	 */
	@SubscribeEvent
	public void biomeEventBiomeColor(BiomeEvent.BiomeColor event) {
		MFEventID currentEventId = MFEventID.BIOME_EVENT_BIOMECOLOR;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * CreateDecorator is fired when a BiomeDecorator is created. This event is
	 * fired whenever a BiomeDecorator is created in
	 * DeferredBiomeDecorator#fireCreateEventAndReplace(BiomeGenBase).
	 * 
	 * BiomeEvent.CreateDecorator.originalBiomeDecorator contains the original
	 * BiomeDecorator that would be used in vanilla.
	 * 
	 */
	@SubscribeEvent
	public void biomeEventCreateDecorator(BiomeEvent.CreateDecorator event) {
		MFEventID currentEventId = MFEventID.BIOME_EVENT_CREATEDECORATOR;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * This event is fired when a biome is queried for its grass color.
	 * 
	 */
	@SubscribeEvent
	public void biomeEventGetFoliageColor(BiomeEvent.GetFoliageColor event) {
		MFEventID currentEventId = MFEventID.BIOME_EVENT_GETFOLIAGECOLOR;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * This event is fired when a biome is queried for its grass color.
	 * 
	 */
	@SubscribeEvent
	public void biomeEventGetGrassColor(BiomeEvent.GetGrassColor event) {
		MFEventID currentEventId = MFEventID.BIOME_EVENT_GETGRASSCOLOR;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * This event is fired when the village generator attempts to choose a block
	 * ID based on the village's biome.
	 * 
	 */
	@SubscribeEvent
	public void biomeEventGetVillageBlockID(BiomeEvent.GetVillageBlockID event) {
		MFEventID currentEventId = MFEventID.BIOME_EVENT_GETVILLAGEBLOCKID;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * This event is fired when a biome is queried for its water color.
	 * 
	 */
	@SubscribeEvent
	public void biomeEventGetWaterColor(BiomeEvent.GetWaterColor event) {
		MFEventID currentEventId = MFEventID.BIOME_EVENT_GETWATERCOLOR;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * This event is fired before a chunks terrain noise field is initialized.
	 * 
	 */
	@SubscribeEvent
	public void chunkProviderEventInitNoiseField(ChunkProviderEvent.InitNoiseField event) {
		MFEventID currentEventId = MFEventID.CHUNKPROVIDER_EVENT_INITNOISEFIELD;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * This event is fired when a chunks blocks are replaced by a biomes top and
	 * filler blocks.
	 * 
	 */
	@SubscribeEvent
	public void chunkProviderEventReplaceBiomeBlocks(ChunkProviderEvent.ReplaceBiomeBlocks event) {
		MFEventID currentEventId = MFEventID.CHUNKPROVIDER_EVENT_REPLACEBIOMEBLOCKS;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * DecorateBiomeEvent is fired when a BiomeDecorator is created.
	 * 
	*/
	
	/*
	 * This event is fired when a chunk is decorated with a biome feature.
	 * 
	 */
	@SubscribeEvent
	public void decorateBiomeEventDecorate(DecorateBiomeEvent.Decorate event) {
		MFEventID currentEventId = MFEventID.DECORATEBIOME_EVENT_DECORATE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * This event is fired after a chunk is decorated with a biome feature.
	 * 
	 */
	@SubscribeEvent
	public void decorateBiomeEventPost(DecorateBiomeEvent.Post event) {
		MFEventID currentEventId = MFEventID.DECORATEBIOME_EVENT_POST;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * This event is fired before a chunk is decorated with a biome feature.
	 * 
	 */
	@SubscribeEvent
	public void decorateBiomeEventPre(DecorateBiomeEvent.Pre event) {
		MFEventID currentEventId = MFEventID.DECORATEBIOME_EVENT_PRE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * 
	 */
	@SubscribeEvent
	public void initMapGenEvent(InitMapGenEvent event) {
		MFEventID currentEventId = MFEventID.INITMAPGEN_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * 
	 */
	@SubscribeEvent
	public void initNoiseGensEvent(InitNoiseGensEvent event) {
		MFEventID currentEventId = MFEventID.INITNOISEGENS_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PopulateChunkEvent is fired when an event involving chunk terrain feature
	 * population occurs. If a method utilizes this Event as its parameter, the
	 * method will receive every child event of this class.
	 * 
	 * PopulateChunkEvent.world contains the world this event is occurring in.
	 * 
	 * PopulateChunkEvent.rand contains an instance of random that can be used
	 * in this event.
	 * 
	 * PopulateChunkEvent.chunkX contains the x-coordinate of the chunk
	 * currently being populated with a terrain feature.
	 * 
	 * PopulateChunkEvent.chunkZ contains the z-coordinate of the chunk
	 * currently being populated with ores.
	 * 
	 * PopulateChunkEvent.hasVillageGenerated contains the boolean value stating
	 * if the chunk already has a village spawned in it.
	 * 
	 * All children of this event are fired on the MinecraftForge#EVENT_BUS,
	 * except PopulateChunkEvent.Populate, which fires on the
	 * MinecraftForge#TERRAIN_GEN_BUS.
	*/

	/*
	 * PopulateChunkEvent.Populate is fired when a chunk is populated with a
	 * terrain feature. This event is fired during terrain feature generation in
	 * ChunkProviderEnd#populate(IChunkProvider, int, int),
	 * ChunkProviderGenerate#populate(IChunkProvider, int, int), and
	 * ChunkProviderHell#populate(IChunkProvider, int, int).
	 * 
	 */
	@SubscribeEvent
	public void populateChunkEventPopulate(PopulateChunkEvent.Populate event) {
		MFEventID currentEventId = MFEventID.POPULATECHUNK_EVENT_POPULATE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PopulateChunkEvent.Post is fired just after a chunk is populated with a
	 * terrain feature. This event is fired just after terrain feature
	 * generation in ChunkProviderEnd#populate(IChunkProvider, int, int),
	 * ChunkProviderGenerate#populate(IChunkProvider, int, int), and
	 * ChunkProviderHell#populate(IChunkProvider, int, int).
	 * 
	 */
	@SubscribeEvent
	public void populateChunkEventPost(PopulateChunkEvent.Post event) {
		MFEventID currentEventId = MFEventID.POPULATECHUNK_EVENT_POST;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PopulateChunkEvent.Pre is fired just before a chunk is populated a
	 * terrain feature. This event is fired just before terrain feature
	 * generation in ChunkProviderEnd#populate(IChunkProvider, int, int),
	 * ChunkProviderGenerate#populate(IChunkProvider, int, int), and
	 * ChunkProviderHell#populate(IChunkProvider, int, int).
	 * 
	 */
	@SubscribeEvent
	public void populateChunkEventPre(PopulateChunkEvent.Pre event) {
		MFEventID currentEventId = MFEventID.POPULATECHUNK_EVENT_PRE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * SaplingGrowTreeEvent is fired when a sapling grows into a tree. This
	 * event is fired during sapling growth in BlockSapling#func_149878_d(World,
	 * BlockPos, Random).
	 * 
	 * SaplingGrowTreeEvent.pos contains the coordinates of the growing sapling.
	 * 
	 */
	@SubscribeEvent
	public void saplingGrowTreeEvent(SaplingGrowTreeEvent event) {
		MFEventID currentEventId = MFEventID.SAPLINGGROWTREEEVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * WorldTypeEvent is fired when an event involving the world occurs. If a
	 * method utilizes this Event as its parameter, the method will receive
	 * every child event of this class.
	 * 
	 * WorldTypeEvent.worldType contains the WorldType of the world this event
	 * is occurring in.
	 * 
	 * All children of this event are fired on the
	 * MinecraftForge#TERRAIN_GEN_BUS.
	 * 
*/
	
	/*
	 * BiomeSize is fired when vanilla Minecraft attempts to generate biomes.
	 * This event is fired during biome generation in
	 * GenLayer#initializeAllBiomeGenerators(long, WorldType).
	 * 
	 */
	@SubscribeEvent
	public void worldTypeEventBiomeSize(WorldTypeEvent.BiomeSize event) {
		MFEventID currentEventId = MFEventID.WORLDTYPEEVENT_BIOMESIZE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * InitBiomeGens is fired when vanilla Minecraft attempts to initialize the
	 * biome generators. This event is fired just during biome generator
	 * initialization in WorldChunkManager#WorldChunkManager(long, WorldType).
	 * 
	 */
	@SubscribeEvent
	public void worldTypeEventInitBiomeGens(WorldTypeEvent.InitBiomeGens event) {
		MFEventID currentEventId = MFEventID.WORLDTYPEEVENT_INITBIOMEGENS;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

}
