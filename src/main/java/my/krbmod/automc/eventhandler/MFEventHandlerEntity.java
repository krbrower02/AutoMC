package my.krbmod.automc.eventhandler;

import java.util.EnumMap;
import java.util.Map;
import my.krbmod.automc.utility.LogHelper;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MFEventHandlerEntity {

	public static String handlerName = "Entity Event Handler";
	public static boolean eventCounting = true;
	public static boolean eventLogging = true;

	public static EnumMap<MFEventID, MFEvent> localEvents = new EnumMap<MFEventID, MFEvent>(MFEventID.class);

	protected enum MFEventID {
		//ENTITY_EVENT - do not subscribe to parent event
		ENTITY_EVENT_CANUPDATE, ENTITY_EVENT_ENTERINGCHUNK, ENTITY_EVENT_ENTITYCONSTRUCTING, ENTITYJOINWORLD_EVENT, ENTITYMOUNT_EVENT, ENTITYSTRUCKBYLIGHTNING_EVENT, ENTITYTRAVELTODIMENSION_EVENT, PLAYSOUNDATENTITY_EVENT
	}

	public static void logEventCounts() {
		if (eventCounting) {
			LogHelper.info(String.format(handlerName+" : %d elements",localEvents.size()));
			for (Map.Entry<MFEventID, MFEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}

		}

	}

	public MFEventHandlerEntity() {
		LogHelper.info(handlerName+" has been setup");
		localEvents.put(MFEventID.ENTITY_EVENT_CANUPDATE, new MFEvent("Entity: Entity Event - Can Update", false));
		localEvents.put(MFEventID.ENTITY_EVENT_ENTERINGCHUNK, new MFEvent("Entity: Entity Event - Entering Chunk", false));
		localEvents.put(MFEventID.ENTITY_EVENT_ENTITYCONSTRUCTING,
				new MFEvent("Entity: Entity Event - Entity Constructing", false));
		localEvents.put(MFEventID.ENTITYJOINWORLD_EVENT, new MFEvent("Entity: Entity Join World Event", false));
		localEvents.put(MFEventID.ENTITYMOUNT_EVENT, new MFEvent("Entity: Entity Mount Event", true));
		localEvents.put(MFEventID.ENTITYSTRUCKBYLIGHTNING_EVENT, new MFEvent("Entity: Entity Struck By Lightning Event", true));
		localEvents.put(MFEventID.ENTITYTRAVELTODIMENSION_EVENT, new MFEvent("Entity: Entity Travel To Dimension Event", true));
		localEvents.put(MFEventID.PLAYSOUNDATENTITY_EVENT, new MFEvent("Entity: Play Sound At Entity Event", false));

	}

	/*
	 * EntityEvent is fired when an event involving any Entity occurs. If a
	 * method utilizes this Event as its parameter, the method will receive
	 * every child event of this class.
	 * 
	 * EntityEvent.entity contains the entity that caused this event to occur.
	 * 
	 * All children of this event are fired on the MinecraftForge#EVENT_BUS.
	 * 
*/
	
	/*
	 * CanUpdate is fired when an Entity is being created.
	 * 
	 */
	@SubscribeEvent
	public void entityEventCanUpdate(EntityEvent.CanUpdate event) {
		MFEventID currentEventId = MFEventID.ENTITY_EVENT_CANUPDATE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}
	
	/*
	 * EnteringChunk is fired when an Entity enters a chunk.
	 * 
	 */
	@SubscribeEvent
	public void entityEventEnteringChunk(EntityEvent.EnteringChunk event) {
		MFEventID currentEventId = MFEventID.ENTITY_EVENT_ENTERINGCHUNK;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * EntityConstructing is fired when an Entity is being created.
	 * 
	 */
	@SubscribeEvent
	public void entityEvententityConstructing(EntityEvent.EntityConstructing event) {
		MFEventID currentEventId = MFEventID.ENTITY_EVENT_ENTITYCONSTRUCTING;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * EntityJoinWorldEvent is fired when an Entity joins the world.
	 * 
	 */
	@SubscribeEvent
	public void entityJoinWorldEvent(EntityJoinWorldEvent event) {
		MFEventID currentEventId = MFEventID.ENTITYJOINWORLD_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * This event gets fired whenever a entity mounts/dismounts another entity.
	 * entityBeingMounted can be null, be sure to check for that.
	 * 
	 */
	@SubscribeEvent
	public void entityMountEvent(EntityMountEvent event) {
		MFEventID currentEventId = MFEventID.ENTITYMOUNT_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * EntityStruckByLightningEvent is fired when an Entity is about to be
	 * struck by lightening. This event is fired whenever an EntityLightningBolt
	 * is updated to strike an Entity in EntityLightningBolt#onUpdate() via
	 * ForgeEventFactory#onEntityStruckByLightning(Entity, EntityLightningBolt).
	 * 
	 * EntityStruckByLightningEvent.lightning contains the instance of
	 * EntityLightningBolt attempting to strike an entity.
	 * 
	 * This event is Cancelable. If this event is canceled, the Entity is not
	 * struck by the lightening.
	 * 
	 * This event does not have a result.
	 * 
	 */
	@SubscribeEvent
	public void entityStruckByLightningEvent(EntityStruckByLightningEvent event) {
		MFEventID currentEventId = MFEventID.ENTITYSTRUCKBYLIGHTNING_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * EntityTravelToDimensionEvent is fired before an Entity travels to a
	 * dimension.
	 * 
	 * EntityTravelToDimensionEvent.dimension contains the id of the dimension
	 * the entity is traveling to.
	 * 
	 * This event is Cancelable. If this event is canceled, the Entity does not
	 * travel to the dimension.
	 * 
	 * This event does not have a result.
	 * 
	 */
	@SubscribeEvent
	public void entityTravelToDimensionEvent(EntityTravelToDimensionEvent event) {
		MFEventID currentEventId = MFEventID.ENTITYTRAVELTODIMENSION_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlaySoundAtEntityEvent is fired a sound is to be played at an Entity This
	 * event is fired whenever a sound is set to be played at an Entity such as
	 * in EntityPlayerSP#playSound(String, float, float),
	 * World#playSoundAtEntity(Entity, String, float, float), and
	 * World#playerSoundToNearExcept(EntityPlayer, String, float, float).
	 * 
	 * PlaySoundAtEntityEvent.name contains the name of the sound to be played
	 * at the Entity.
	 * 
	 * PlaySoundAtEntityEvent.volume contains the volume at which the sound is
	 * to be played originally.
	 * 
	 * PlaySoundAtEntityEvent.pitch contains the pitch at which the sound is to
	 * be played originally.
	 * 
	 * PlaySoundAtEntityEvent.newVolume contains the volume at which the sound
	 * is actually played. PlaySoundAtEntityEvent.newPitch contains the pitch at
	 * which the sound is actually played.
	 * 
	 * Changing the PlaySoundAtEntityEvent.name field will cause the sound of
	 * this name to be played instead of the originally intended sound.
	 * 
	 * This event is Cancelable. If this event is canceled, the sound is not
	 * played.
	 * 
	 * This event does not have a result.
	 * 
	 */
	@SubscribeEvent
	public void playSoundAtEntityEvent(PlaySoundAtEntityEvent event) {
		MFEventID currentEventId = MFEventID.PLAYSOUNDATENTITY_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

}
