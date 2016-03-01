package my.krbmod.automc.eventhandler;

import java.util.EnumMap;
import java.util.Map;

import my.krbmod.automc.eventhandler.MFEventHandler.MFEventId;
import my.krbmod.automc.utility.LogHelper;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.ChunkWatchEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MFEventHandlerWorld {

	public static String handlerName = "World Event Handler";
	public static boolean eventCounting = true;
	public static boolean eventLogging = true;
	public static MFEventId currentEventId;

	public static EnumMap<MFEventId, MFEvent> localEvents = new EnumMap<MFEventId, MFEvent>(MFEventId.class);

	protected enum MFEventId {

		//BLOCKEVENT- do not subscribe to parent event
		BLOCKEVENT_BREAKEVENT,
		BLOCKEVENT_HARVESTDROPSEVENT,
		BLOCKEVENT_MULTIPLACEEVENT,
		BLOCKEVENT_NEIGHBORNOTIFYEVENT,
		BLOCKEVENT_PLACEEVENT,
		//CHUNKDATAEVENT- do not subscribe to parent event
		CHUNKDATAEVENT_LOAD,
		CHUNKDATAEVENT_SAVE,
		//CHUNKEVENT- do not subscribe to parent event
		CHUNKEVENT_LOAD,
		CHUNKEVENT_UNLOAD,
		//CHUNKWATCHEVENT- do not subscribe to parent event
		CHUNKWATCHEVENT_UNWATCH,
		CHUNKWATCHEVENT_WATCH,
		//EXPLOSIONEVENT- do not subscribe to parent event
		EXPLOSIONEVENT_DETONATE,
		EXPLOSIONEVENT_START,
		//NOTEBLOCKEVENT- do not subscribe to parent event
		NOTEBLOCKEVENT_CHANGE,
		NOTEBLOCKEVENT_PLAY,
		//WORLDEVENT- do not subscribe to parent event
		WORLDEVENT_CREATESPAWNPOSITION,
		WORLDEVENT_LOAD,
		WORLDEVENT_POTENTIALSPAWNS,
		WORLDEVENT_SAVE,
		WORLDEVENT_UNLOAD
	}

	public static void logEventCounts() {
		if (eventCounting) {
			LogHelper.info(String.format(handlerName+" : %d elements",localEvents.size()));
			for (Map.Entry<MFEventId, MFEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}

		}

	}

	public MFEventHandlerWorld() {
		LogHelper.info(handlerName+" has been setup");
		localEvents.put(MFEventId.BLOCKEVENT_BREAKEVENT, new MFEvent("Block Event - Break Event", true));
		localEvents.put(MFEventId.BLOCKEVENT_HARVESTDROPSEVENT, new MFEvent("Block Event - Harves tDrops Event", true));
		localEvents.put(MFEventId.BLOCKEVENT_MULTIPLACEEVENT, new MFEvent("Block Event - Multi Place Event", true));
		localEvents.put(MFEventId.BLOCKEVENT_NEIGHBORNOTIFYEVENT, new MFEvent("Block Event - Neighbor Notify Event", true));
		localEvents.put(MFEventId.BLOCKEVENT_PLACEEVENT, new MFEvent("Block Event - Place Event", true));
		localEvents.put(MFEventId.CHUNKDATAEVENT_LOAD, new MFEvent("Chunk Data Event - Load", false));
		localEvents.put(MFEventId.CHUNKDATAEVENT_SAVE, new MFEvent("Chunk Data Event - Save", false));
		localEvents.put(MFEventId.CHUNKEVENT_LOAD, new MFEvent("Chunk Event - Load", false));
		localEvents.put(MFEventId.CHUNKEVENT_UNLOAD, new MFEvent("Chunk Event - Unload", false));
		localEvents.put(MFEventId.CHUNKWATCHEVENT_UNWATCH, new MFEvent("Chunk Watch Event - UnWatch", false));
		localEvents.put(MFEventId.CHUNKWATCHEVENT_WATCH, new MFEvent("Chunk Watch Event - Watch", false));
		localEvents.put(MFEventId.EXPLOSIONEVENT_DETONATE, new MFEvent("Explosion Event - Detonate", true));
		localEvents.put(MFEventId.EXPLOSIONEVENT_START, new MFEvent("Explosion Event - Start", true));
		localEvents.put(MFEventId.NOTEBLOCKEVENT_CHANGE, new MFEvent("NoteBloc kEvent - Change", true));
		localEvents.put(MFEventId.NOTEBLOCKEVENT_PLAY, new MFEvent("NoteBlock Event - Play", true));
		localEvents.put(MFEventId.WORLDEVENT_CREATESPAWNPOSITION, new MFEvent("World Event - CreateSpawn Position", true));
		localEvents.put(MFEventId.WORLDEVENT_LOAD, new MFEvent("World Event - Load", false));
		localEvents.put(MFEventId.WORLDEVENT_POTENTIALSPAWNS, new MFEvent("World Event - Potential Spawns", false));
		localEvents.put(MFEventId.WORLDEVENT_SAVE, new MFEvent("WorldEvent - Save", true));
		localEvents.put(MFEventId.WORLDEVENT_UNLOAD, new MFEvent("World Event - Unload", true));

	}

	/*
Event that is fired when an Block is about to be broken by a player Canceling this event will prevent the Block from being broken.
	 * 
	 */
	@SubscribeEvent
	public void blockEventBreakEvent(BlockEvent.BreakEvent event) {
		currentEventId = MFEventId.BLOCKEVENT_BREAKEVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
Fired when a block is about to drop it's harvested items.
	 * 
	 */
	@SubscribeEvent
	public void blockEventHarvestDropsEvent(BlockEvent.HarvestDropsEvent event) {
		currentEventId = MFEventId.BLOCKEVENT_HARVESTDROPSEVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
Fired when a single block placement action of a player triggers the creation of multiple blocks(e.g.
	 * 
	 */
	@SubscribeEvent
	public void blockEventMultiPlaceEvent(BlockEvent.MultiPlaceEvent event) {
		currentEventId = MFEventId.BLOCKEVENT_MULTIPLACEEVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
Fired when a physics update occurs on a block.
	 * 
	 */
	@SubscribeEvent
	public void blockEventNeighborNotifyEvent(BlockEvent.NeighborNotifyEvent event) {
		currentEventId = MFEventId.BLOCKEVENT_NEIGHBORNOTIFYEVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
Called when a block is placed by a player.
	 * 
	 */
	@SubscribeEvent
	public void blockEventPlaceEvent(BlockEvent.PlaceEvent event) {
		currentEventId = MFEventId.BLOCKEVENT_PLACEEVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
ChunkDataEvent is fired when an event involving chunk data occurs.
If a method utilizes this Event as its parameter, the method will receive every child event of this class.

ChunkDataEvent.data contains the NBTTagCompound containing the chunk data for this event.

All children of this event are fired on the MinecraftForge#EVENT_BUS.
*/
	
	/*
ChunkDataEvent.Load is fired when vanilla Minecraft attempts to load Chunk data.
This event is fired during chunk loading in ChunkIOProvider#callStage2(QueuedChunk, Chunk).
	 * 
	 */
	@SubscribeEvent
	public void chunkDataEventLoad(ChunkDataEvent.Load event) {
		currentEventId = MFEventId.CHUNKDATAEVENT_LOAD;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
ChunkDataEvent.Save is fired when vanilla Minecraft attempts to save Chunk data.
This event is fired during chunk saving in AnvilChunkLoader#saveChunk(World, Chunk).
	 * 
	 */
	@SubscribeEvent
	public void chunkDataEventSave(ChunkDataEvent.Save event) {
		currentEventId = MFEventId.CHUNKDATAEVENT_SAVE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
ChunkEvent is fired when an event involving a chunk occurs.
If a method utilizes this Event as its parameter, the method will receive every child event of this class.

ChunkEvent.chunk contains the Chunk this event is affecting.

All children of this event are fired on the MinecraftForge#EVENT_BUS.
	 * 
	 */
	
	/*
ChunkEvent.Load is fired when vanilla Minecraft attempts to load a Chunk into the world.
This event is fired during chunk loading in
ChunkProviderClient#loadChunk(int, int),
Chunk.onChunkLoad().
	 * 
	 */
	@SubscribeEvent
	public void chunkEventLoad(ChunkEvent.Load event) {
		currentEventId = MFEventId.CHUNKEVENT_LOAD;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
ChunkEvent.Unload is fired when vanilla Minecraft attempts to unload a Chunk from the world.
This event is fired during chunk unloading in
Chunk.onChunkUnload().
	 * 
	 */
	@SubscribeEvent
	public void chunkEventUnload(ChunkEvent.Unload event) {
		currentEventId = MFEventId.CHUNKEVENT_UNLOAD;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
ChunkWatchEvent is fired when an event involving a chunk being watched occurs.
If a method utilizes this Event as its parameter, the method will receive every child event of this class.

ChunkWatchEvent.chunk contains the ChunkCoordIntPair of the Chunk this event is affecting.
ChunkWatchEvent.player contains the EntityPlayer that is involved with this chunk being watched.
*/
	
/*
ChunkWatchEvent.UnWatch is fired when an EntityPlayer stops watching a chunk.
This event is fired when a chunk is removed from the watched chunks of an EntityPlayer in PlayerInstance#removePlayer(EntityPlayerMP).
	 * 
	 */
	@SubscribeEvent
	public void chunkWatchEventUnWatch(ChunkWatchEvent.UnWatch event) {
		currentEventId = MFEventId.CHUNKWATCHEVENT_UNWATCH;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
ChunkWatchEvent.Watch is fired when an EntityPlayer begins watching a chunk.
This event is fired when a chunk is added to the watched chunks of an EntityPlayer in EntityPlayerMP#onUpdate().
	 * 
	 */
	@SubscribeEvent
	public void chunkWatchEventWatch(ChunkWatchEvent.Watch event) {
		currentEventId = MFEventId.CHUNKWATCHEVENT_WATCH;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
ExplosionEvent triggers when an explosion happens in the world.

ExplosionEvent.Start is fired before the explosion actually occurs.
ExplosionEvent.Detonate is fired once the explosion has a list of affected blocks and entities.

ExplosionEvent.Start is Cancelable.
ExplosionEvent.Detonate can modify the affected blocks and entities.
Children do not use HasResult.
Children of this event are fired on the MinecraftForge#EVENT_BUS.
*/
	
	/*
ExplosionEvent.Detonate is fired once the explosion has a list of affected blocks and entities.
	 * 
	 */
	@SubscribeEvent
	public void explosionEventDetonate(ExplosionEvent.Detonate event) {
		currentEventId = MFEventId.EXPLOSIONEVENT_DETONATE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
ExplosionEvent.Start is fired before the explosion actually occurs.
	 * 
	 */
	@SubscribeEvent
	public void explosionEventStart(ExplosionEvent.Start event) {
		currentEventId = MFEventId.EXPLOSIONEVENT_START;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * NoteBlockEvent
	 * Base class for Noteblock Events
	 */
	
	/*
Fired when a Noteblock is changed.
	 * 
	 */
	@SubscribeEvent
	public void noteBlockEventChange(NoteBlockEvent.Change event) {
		currentEventId = MFEventId.NOTEBLOCKEVENT_CHANGE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
Fired when a Noteblock plays it's note.
	 * 
	 */
	@SubscribeEvent
	public void noteBlockEventPlay(NoteBlockEvent.Play event) {
		currentEventId = MFEventId.NOTEBLOCKEVENT_PLAY;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
WorldEvent is fired when an event involving the world occurs.
If a method utilizes this Event as its parameter, the method will receive every child event of this class.

WorldEvent.world contains the World this event is occuring in.

All children of this event are fired on the MinecraftForge#EVENT_BUS.
*/
	
	/*
Called by WorldServer when it attempts to create a spawnpoint for a dimension.
	 * 
	 */
	@SubscribeEvent
	public void worldEventCreateSpawnPosition(WorldEvent.CreateSpawnPosition event) {
		currentEventId = MFEventId.WORLDEVENT_CREATESPAWNPOSITION;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
WorldEvent.Load is fired when Minecraft loads a world.
This event is fired when a world is loaded in WorldClient#WorldClient(NetHandlerPlayClient, WorldSettings, int, EnumDifficulty, Profiler), MinecraftServer#loadAllWorlds(String, String, long, WorldType, String), DimensionManager#initDimension(int), and ForgeInternalHandler#onDimensionLoad(Load).
	 * 
	 */
	@SubscribeEvent
	public void worldEventLoad(WorldEvent.Load event) {
		currentEventId = MFEventId.WORLDEVENT_LOAD;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
Called by WorldServer to gather a list of all possible entities that can spawn at the specified location.
	 * 
	 */
	@SubscribeEvent
	public void worldEventPotentialSpawns(WorldEvent.PotentialSpawns event) {
		currentEventId = MFEventId.WORLDEVENT_POTENTIALSPAWNS;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
WorldEvent.Save is fired when Minecraft saves a world.
This event is fired when a world is saved in WorldServer#saveAllChunks(boolean, IProgressUpdate), ForgeInternalHandler#onDimensionSave(Save).
	 * 
	 */
	@SubscribeEvent
	public void worldEventSave(WorldEvent.Save event) {
		currentEventId = MFEventId.WORLDEVENT_SAVE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
WorldEvent.Unload is fired when Minecraft unloads a world.
This event is fired when a world is unloaded in Minecraft#loadWorld(WorldClient, String), MinecraftServer#deleteWorldAndStopServer(), MinecraftServer#stopServer(), DimensionManager#unloadWorlds(Hashtable), ForgeInternalHandler#onDimensionUnload(Unload).
	 * 
	 */
	@SubscribeEvent
	public void worldEventUnload(WorldEvent.Unload event) {
		currentEventId = MFEventId.WORLDEVENT_UNLOAD;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

}
