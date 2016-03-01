package my.krbmod.automc.eventhandler;

import java.util.EnumMap;
import java.util.Map;

import my.krbmod.automc.utility.LogHelper;
import net.minecraftforge.event.entity.player.AchievementEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.event.entity.player.PlayerSetSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.entity.player.SleepingLocationCheckEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MFEventHandlerEntityPlayer {

	public static String handlerName = "Entity Player Event Handler";
	public static boolean eventCounting = true;
	public static boolean eventLogging = true;
	public static MFEventId currentEventId;

	public static EnumMap<MFEventId, MFEvent> localEvents = new EnumMap<MFEventId, MFEvent>(MFEventId.class);

	protected enum MFEventId {
		ACHIEVEMENT_EVENT, ANVILREPAIR_EVENT, ARROWLOOSE_EVENT, ARROWNOCK_EVENT, ATTACKENTITY_EVENT, BONEMEAL_EVENT, ENTITYINTERACT_EVENT, ENTITYITEMPICKUP_EVENT, FILLBUCKET_EVENT, ITEMTOOLTIP_EVENT, PLAYERDESTROYITEM_EVENT, PLAYERDROPS_EVENT,
		// PLAYER_EVENT - do not subscribe to parent event
		PLAYER_EVENT_BREAKSPEED, PLAYER_EVENT_CLONE, PLAYER_EVENT_HARVESTCHECK, PLAYER_EVENT_LOADFROMFILE, PLAYER_EVENT_NAMEFORMAT, PLAYER_EVENT_SAVETOFILE, PLAYER_EVENT_STARTTRACKING, PLAYER_EVENT_STOPTRACKING, PLAYERFLYABLEFALL_EVENT, PLAYERINTERACT_EVENT, PLAYEROPENCONTAINER_EVENT, PLAYERPICKUPXP_EVENT, PLAYERSETSPAWN_EVENT, PLAYERSLEEPINBED_EVENT,
		// PLAYERUSEITEM_EVENT - do not subscribe to parent event
		PLAYERUSEITEM_EVENT_FINISH, PLAYERUSEITEM_EVENT_START, PLAYERUSEITEM_EVENT_STOP, PLAYERUSEITEM_EVENT_TICK, PLAYERWAKEUP_EVENT, SLEEPINGLOCATIONCHECK_EVENT, USEHOE_EVENT
	}

	public static void logEventCounts() {
		if (eventCounting) {
			LogHelper.info(String.format(handlerName + " : %d elements", localEvents.size()));
			for (Map.Entry<MFEventId, MFEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}

		}

	}

	public MFEventHandlerEntityPlayer() {
		LogHelper.info(handlerName + " has been setup");
		localEvents.put(MFEventId.ACHIEVEMENT_EVENT, new MFEvent("Achievement", true));
		localEvents.put(MFEventId.ANVILREPAIR_EVENT, new MFEvent("Anvil Repair", true));
		localEvents.put(MFEventId.ARROWLOOSE_EVENT, new MFEvent("Arrow Loose", true));
		localEvents.put(MFEventId.ARROWNOCK_EVENT, new MFEvent("Arrow Nock", true));
		localEvents.put(MFEventId.ATTACKENTITY_EVENT, new MFEvent("Attack Entity", true));
		localEvents.put(MFEventId.BONEMEAL_EVENT, new MFEvent("Bonemeal", true));
		localEvents.put(MFEventId.ENTITYINTERACT_EVENT, new MFEvent("Entity Interact", true));
		localEvents.put(MFEventId.ENTITYITEMPICKUP_EVENT, new MFEvent("Entity Item Pickup", true));
		localEvents.put(MFEventId.FILLBUCKET_EVENT, new MFEvent("Fill Bucket", true));
		localEvents.put(MFEventId.ITEMTOOLTIP_EVENT, new MFEvent("Item Tooltip", true));
		localEvents.put(MFEventId.PLAYERDESTROYITEM_EVENT, new MFEvent("Player Destroy Item", true));
		localEvents.put(MFEventId.PLAYERDROPS_EVENT, new MFEvent("Player Drops", true));
		localEvents.put(MFEventId.PLAYER_EVENT_BREAKSPEED, new MFEvent("Player - Break Speed", false));
		localEvents.put(MFEventId.PLAYER_EVENT_CLONE, new MFEvent("Player - Clone", true));
		localEvents.put(MFEventId.PLAYER_EVENT_HARVESTCHECK, new MFEvent("Player - Harvest Check", true));
		localEvents.put(MFEventId.PLAYER_EVENT_LOADFROMFILE, new MFEvent("Player - Load From File", true));
		localEvents.put(MFEventId.PLAYER_EVENT_NAMEFORMAT, new MFEvent("Player - Name Format", true));
		localEvents.put(MFEventId.PLAYER_EVENT_SAVETOFILE, new MFEvent("Player - Save To File", true));
		localEvents.put(MFEventId.PLAYER_EVENT_STARTTRACKING, new MFEvent("Player - Start Tracking", false));
		localEvents.put(MFEventId.PLAYER_EVENT_STOPTRACKING, new MFEvent("Player - Stop Tracking", true));
		localEvents.put(MFEventId.PLAYERFLYABLEFALL_EVENT, new MFEvent("Player Flyable Fall", true));
		localEvents.put(MFEventId.PLAYERINTERACT_EVENT, new MFEvent("Player Interact", true));
		localEvents.put(MFEventId.PLAYEROPENCONTAINER_EVENT, new MFEvent("Player Open Container", false));
		localEvents.put(MFEventId.PLAYERPICKUPXP_EVENT, new MFEvent("Player Pickup Xp", true));
		localEvents.put(MFEventId.PLAYERSETSPAWN_EVENT, new MFEvent("Player Set Spawn", true));
		localEvents.put(MFEventId.PLAYERSLEEPINBED_EVENT, new MFEvent("Player Sleep In Bed", true));
		localEvents.put(MFEventId.PLAYERUSEITEM_EVENT_FINISH, new MFEvent("Player Use Item - Finish", true));
		localEvents.put(MFEventId.PLAYERUSEITEM_EVENT_START, new MFEvent("Player Use Item - Start", true));
		localEvents.put(MFEventId.PLAYERUSEITEM_EVENT_STOP, new MFEvent("Player Use Item - Stop", true));
		localEvents.put(MFEventId.PLAYERUSEITEM_EVENT_TICK, new MFEvent("Player Use Item - Tick", true));
		localEvents.put(MFEventId.PLAYERWAKEUP_EVENT, new MFEvent("Player Wake Up", true));
		localEvents.put(MFEventId.SLEEPINGLOCATIONCHECK_EVENT, new MFEvent("Sleeping Location Check", true));
		localEvents.put(MFEventId.USEHOE_EVENT, new MFEvent("Use Hoe", true));
	}

	/*
	 * AchievementEvent When the player receives an achievement.
	 * 
	 */
	@SubscribeEvent
	public void achievementEvent(AchievementEvent event) {
		currentEventId = MFEventId.ACHIEVEMENT_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * AnvilRepairEvent
	 */
	@SubscribeEvent
	public void anvilRepairEvent(AnvilRepairEvent event) {
		currentEventId = MFEventId.ANVILREPAIR_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * ArrowLooseEvent ArrowLooseEvent is fired when a player stops using a bow.
	 * This event is fired whenever a player stops using a bow in
	 * ItemBow#onPlayerStoppedUsing(ItemStack, World, EntityPlayer, public int).
	 * 
	 * ArrowLooseEvent.bow contains the ItemBow ItemStack that was used in this
	 * event. ArrowLooseEvent.charge contains the value for how much the player
	 * had charged before stopping the shot.
	 * 
	 * This event is Cancelable. If this event is canceled, the player does not
	 * stop using the bow.
	 * 
	 * This event does not have a result.
	 * 
	 */
	@SubscribeEvent
	public void arrowLooseEvent(ArrowLooseEvent event) {
		currentEventId = MFEventId.ARROWLOOSE_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * ArrowNockEvent ArrowNockEvent is fired when a player begins using a bow.
	 * This event is fired whenever a player begins using a bow in
	 * ItemBow#onItemRightClick(ItemStack, World, EntityPlayer).
	 * 
	 * ArrowNockEvent.result contains the resulting ItemStack due to the use of
	 * the bow.
	 */
	@SubscribeEvent
	public void arrowNockEvent(ArrowNockEvent event) {
		currentEventId = MFEventId.ARROWNOCK_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * AttackEntityEvent AttackEntityEvent is fired when a player attacks an
	 * Entity. This event is fired whenever a player attacks an Entity in
	 * EntityPlayer#attackTargetEntityWithCurrentItem(Entity).
	 * 
	 * AttackEntityEvent.target contains the Entity that was damaged by the
	 * player.
	 */
	@SubscribeEvent
	public void attackEntityEvent(AttackEntityEvent event) {
		currentEventId = MFEventId.ATTACKENTITY_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);

	}

	/*
	 * BonemealEvent
	 */
	@SubscribeEvent
	public void bonemealEvent(BonemealEvent event) {
		currentEventId = MFEventId.BONEMEAL_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * Entitypublic interactEvent Entitypublic interactEvent is fired when a
	 * player public interacts with an Entity. This event is fired whenever a
	 * player public interacts with an Entity in EntityPlayer#public
	 * interactWith(Entity).
	 * 
	 * Entitypublic interactEvent.target contains the Entity the player public
	 * interacted with.
	 * 
	 */
	@SubscribeEvent
	public void entityInteractEvent(EntityInteractEvent event) {
		currentEventId = MFEventId.ENTITYINTERACT_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);

	}

	/*
	 * EntityItemPickupEvent
	 */
	@SubscribeEvent
	public void entityItemPickupEvent(EntityItemPickupEvent event) {
		currentEventId = MFEventId.ENTITYITEMPICKUP_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * FillBucketEvent
	 */
	@SubscribeEvent
	public void fillBucketEvent(FillBucketEvent event) {
		currentEventId = MFEventId.FILLBUCKET_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * ItemTooltipEvent
	 */
	@SubscribeEvent
	public void itemTooltipEvent(ItemTooltipEvent event) {
		currentEventId = MFEventId.ITEMTOOLTIP_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);

	}

	/*
	 * PlayerDestroyItemEvent PlayerDestroyItemEvent is fired when a player
	 * destroys an item. This event is fired whenever a player destroys an item
	 * in PlayerControllerMP#onPlayerRightClick(EntityPlayer, World, ItemStack,
	 * int, int, int, int, Vec3), PlayerControllerMP#sendUseItem(EntityPlayer,
	 * World, ItemStack), EntityPlayer#destroyCurrentEquippedItem(),
	 * SlotCrafting#onPickupFromSlot(EntityPlayer, ItemStack),
	 * ItemInWorldManager#tryUseItem(EntityPlayer, World, ItemStack), and
	 * ItemInWorldManager#activateBlockOrUseItem(EntityPlayer, World, ItemStack,
	 * int, int, int, int, float, float, float).
	 * 
	 * PlayerDestroyItemEvent.original contains the original ItemStack before
	 * the item was destroyed.
	 */
	@SubscribeEvent
	public void playerDestroyItemEvent(PlayerDestroyItemEvent event) {
		currentEventId = MFEventId.PLAYERDESTROYITEM_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerDropsEvent Child class of LivingDropEvent that is fired
	 * specifically when a player dies.
	 */
	@SubscribeEvent
	public void playerDropsEvent(PlayerDropsEvent event) {
		currentEventId = MFEventId.PLAYERDROPS_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerEvent PlayerEvent is fired whenever an event involving Living
	 * entities occurs.
	 */

	/*
	 * PlayerEvent.BreakSpeed BreakSpeed is fired when a player attempts to
	 * harvest a block. This event is fired whenever a player attempts to
	 * harvest a block in EntityPlayer#canHarvestBlock(Block).
	 * 
	 * This event is fired via the ForgeEventFactory#getBreakSpeed(EntityPlayer,
	 * IBlockState, float, BlockPos).
	 * 
	 * PlayerEvent.BreakSpeed.state contains the block being broken.
	 */
	@SubscribeEvent
	public void playerEventBreakSpeed(PlayerEvent.BreakSpeed event) {
		currentEventId = MFEventId.PLAYER_EVENT_BREAKSPEED;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);

	}

	/*
	 * PlayerEvent.Clone Fired when the EntityPlayer is cloned, typically caused
	 * by the network sending a RESPAWN_PLAYER event.
	 */
	@SubscribeEvent
	public void playerEventClone(PlayerEvent.Clone event) {
		currentEventId = MFEventId.PLAYER_EVENT_CLONE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerEvent.HarvestCheck HarvestCheck is fired when a player attempts to
	 * harvest a block. This event is fired whenever a player attempts to
	 * harvest a block in EntityPlayer#canHarvestBlock(Block).
	 * 
	 * This event is fired via the
	 * ForgeEventFactory#doPlayerHarvestCheck(EntityPlayer, Block, boolean).
	 * 
	 * PlayerEvent.HarvestCheck.block contains the Block that is being checked
	 * for harvesting.
	 */
	@SubscribeEvent
	public void playerEventHarvestCheck(PlayerEvent.HarvestCheck event) {
		currentEventId = MFEventId.PLAYER_EVENT_HARVESTCHECK;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerEvent.LoadFromFile The player is being loaded from the world save.
	 */
	@SubscribeEvent
	public void playerEventLoadFromFile(PlayerEvent.LoadFromFile event) {
		currentEventId = MFEventId.PLAYER_EVENT_LOADFROMFILE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerEvent.NameFormat NameFormat is fired when a player's display name
	 * is retrieved. This event is fired whenever a player's name is retrieved
	 * in EntityPlayer#getDisplayName() or EntityPlayer#refreshDisplayName().
	 * 
	 * This event is fired via the
	 * ForgeEventFactory#getPlayerDisplayName(EntityPlayer, String).
	 * 
	 * PlayerEvent.NameFormat.username contains the username of the player.
	 */
	@SubscribeEvent
	public void playerEventNameFormat(PlayerEvent.NameFormat event) {
		currentEventId = MFEventId.PLAYER_EVENT_NAMEFORMAT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerEvent.SaveToFile The player is being saved to the world store.
	 */
	@SubscribeEvent
	public void playerEventSaveToFile(PlayerEvent.SaveToFile event) {
		currentEventId = MFEventId.PLAYER_EVENT_SAVETOFILE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerEvent.StartTracking Fired when an Entity is started to be "tracked"
	 * by this player (the player receives updates about this entity, e.g.
	 */
	@SubscribeEvent
	public void playerEventStartTracking(PlayerEvent.StartTracking event) {
		currentEventId = MFEventId.PLAYER_EVENT_STARTTRACKING;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerEvent.StopTracking Fired when an Entity is stopped to be "tracked"
	 * by this player (the player no longer receives updates about this entity,
	 * e.g.
	 */
	@SubscribeEvent
	public void playerEventStopTracking(PlayerEvent.StopTracking event) {
		currentEventId = MFEventId.PLAYER_EVENT_STOPTRACKING;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerFlyableFallEvent Occurs when a player falls, but is able to fly.
	 */
	@SubscribeEvent
	public void playerFlyableFallEvent(PlayerFlyableFallEvent event) {
		currentEventId = MFEventId.PLAYERFLYABLEFALL_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerInteractEventEvent PlayerInteractEventEvent is fired when a player
	 * public interacts in some way.
	 */
	@SubscribeEvent
	public void playerInteractEvent(PlayerInteractEvent event) {
		currentEventId = MFEventId.PLAYERINTERACT_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerOpenContainerEvent
	 */
	@SubscribeEvent
	public void playerOpenContainerEvent(PlayerOpenContainerEvent event) {
		currentEventId = MFEventId.PLAYEROPENCONTAINER_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerPickupXpEvent This event is called when a player collides with a
	 * EntityXPOrb on the ground.
	 */
	@SubscribeEvent
	public void playerPickupXpEvent(PlayerPickupXpEvent event) {
		currentEventId = MFEventId.PLAYERPICKUPXP_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerSetSpawnEvent
	 */
	@SubscribeEvent
	public void playerSetSpawnEvent(PlayerSetSpawnEvent event) {
		currentEventId = MFEventId.PLAYERSETSPAWN_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerSleepInBedEvent PlayerSleepInBedEvent is fired when a player sleeps
	 * in a bed.
	 */
	@SubscribeEvent
	public void playerSleepInBedEvent(PlayerSleepInBedEvent event) {
		currentEventId = MFEventId.PLAYERSLEEPINBED_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerUseItemEvent
	 */

	/*
	 * PlayerUseItemEvent.Finish Fired after an item has fully finished being
	 * used.
	 */
	@SubscribeEvent
	public void playerUseItemEventFinish(PlayerUseItemEvent.Finish event) {
		currentEventId = MFEventId.PLAYERUSEITEM_EVENT_FINISH;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerUseItemEvent.Start Fired when a player starts 'using' an item,
	 * typically when they hold right mouse.
	 */
	@SubscribeEvent
	public void playerUseItemEventStart(PlayerUseItemEvent.Start event) {
		currentEventId = MFEventId.PLAYERUSEITEM_EVENT_START;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerUseItemEvent.Stop Fired when a player stops using an item without
	 * the use duration timing out.
	 */
	@SubscribeEvent
	public void playerUseItemEventStop(PlayerUseItemEvent.Stop event) {
		currentEventId = MFEventId.PLAYERUSEITEM_EVENT_STOP;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerUseItemEvent.Tick Fired every tick that a player is 'using' an
	 * item, see PlayerUseItemEvent.Start for info.
	 */
	@SubscribeEvent
	public void playerUseItemEventTick(PlayerUseItemEvent.Tick event) {
		currentEventId = MFEventId.PLAYERUSEITEM_EVENT_TICK;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PlayerWakeUpEvent This event is fired when the player is waking up. This
	 * is merely for purposes of listening for this to happen. There is nothing
	 * that can be manipulated with this event.
	 */
	@SubscribeEvent
	public void playerWakeUpEvent(PlayerWakeUpEvent event) {
		currentEventId = MFEventId.PLAYERWAKEUP_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * SleepingLocationCheckEvent This event is fired when game checks, if
	 * sleeping player should be still considered "in bed". Failing this check
	 * will cause player to wake up. This event has a result.
	 */
	@SubscribeEvent
	public void sleepingLocationCheckEvent(SleepingLocationCheckEvent event) {
		currentEventId = MFEventId.SLEEPINGLOCATIONCHECK_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * UseHoeEvent
	 */
	@SubscribeEvent
	public void useHoeEvent(UseHoeEvent event) {
		currentEventId = MFEventId.USEHOE_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);

	}

}
