package my.krbmod.automc.eventhandler;

import java.util.EnumMap;
import java.util.Map;
import my.krbmod.automc.utility.LogHelper;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MFEventHandler {

	public static String handlerName = "MF Event Handler";
	public static boolean eventCounting = true;
	public static boolean eventLogging = true;
	public static MFEventId currentEventId;

	public static EnumMap<MFEventId, MFEvent> localEvents = new EnumMap<MFEventId, MFEvent>(MFEventId.class);

	protected enum MFEventId {
		ANVILUPDATE_EVENT,
		// ATTACHCAPABILITIES_EVENT - do not subscribe to parent event
		ATTACHCAPABILITIES_EVENT_ENTITY, ATTACHCAPABILITIES_EVENT_ITEM, ATTACHCAPABILITIES_EVENT_TILEENTITY, COMMAND_EVENT, 
		//FORGE_EVENTFACTORY - do not subscribe to parent event
		SERVERCHAT_EVENT
	}

	public static void logEventCounts() {
		if (eventCounting) {
			LogHelper.info(String.format(handlerName+" : %d elements",localEvents.size()));
			for (Map.Entry<MFEventId, MFEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}

		}

	}

	public MFEventHandler() {
		LogHelper.info(handlerName+" has been setup");
		localEvents.put(MFEventId.ANVILUPDATE_EVENT, new MFEvent("Event: Anvil Update Event", false));
		localEvents.put(MFEventId.ATTACHCAPABILITIES_EVENT_ENTITY,
				new MFEvent("Event: Attach Capabilities Event Entity", false));
		localEvents.put(MFEventId.ATTACHCAPABILITIES_EVENT_ITEM, new MFEvent("Event: Attach Capabilities Event Item", false));
		localEvents.put(MFEventId.ATTACHCAPABILITIES_EVENT_TILEENTITY,
				new MFEvent("Event: Attach Capabilities Event Tile Entity", false));
		localEvents.put(MFEventId.COMMAND_EVENT, new MFEvent("Event: Command Event", true));
		localEvents.put(MFEventId.SERVERCHAT_EVENT, new MFEvent("Event: Server Chat Event", true));

	}

	/*
	 * AnvilUpdateEvent is fired when a player places items in both the left and
	 * right slots of a anvil.
	 * 
	 */
	@SubscribeEvent
	public void anvilUpdateEvent(AnvilUpdateEvent event) {
		currentEventId = MFEventId.ANVILUPDATE_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * AttachCapabilitiesEvent
	 * 
	 * Fired whenever an object with Capabilities support {currently
	 * TileEntity/Item/Entity) is created.
	 */

	/*
	 * A version of the parent event which is only fired for Entities.
	 * 
	 */
	@SubscribeEvent
	public void attachCapabilitiesEventEntity(AttachCapabilitiesEvent.Entity event) {
		currentEventId = MFEventId.ATTACHCAPABILITIES_EVENT_ENTITY;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * A version of the parent event which is only fired for ItemStacks.
	 * 
	 */
	@SubscribeEvent
	public void attachCapabilitiesEventItem(AttachCapabilitiesEvent.Item event) {
		currentEventId = MFEventId.ATTACHCAPABILITIES_EVENT_ITEM;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * A version of the parent event which is only fired for Tile Entities.
	 * 
	 */
	@SubscribeEvent
	public void attachCapabilitiesEventTileEntity(AttachCapabilitiesEvent.TileEntity event) {
		currentEventId = MFEventId.ATTACHCAPABILITIES_EVENT_TILEENTITY;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * CommandEvent is fired whenever a command is scheduled to be executed.
	 * 
	 */
	@SubscribeEvent
	public void commandEvent(CommandEvent event) {
		currentEventId = MFEventId.COMMAND_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * ServerChatEvent is fired whenever a C01PacketChatMessage is processed.
	 * 
	 */
	@SubscribeEvent
	public void serverChatEvent(ServerChatEvent event) {
		currentEventId = MFEventId.SERVERCHAT_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

}
