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

public class EntityPlayerEventHandler {

	public static boolean eventCounting = true;
	public static boolean eventLogging = true;
	public static LocalEventId currentEvent;

	public static EnumMap<LocalEventId, LocalEvent> localEvents = new EnumMap<LocalEventId, LocalEvent>(LocalEventId.class);

	protected enum LocalEventId {
		ACHIEVEMENT_EVENT, ANVILREPAIR_EVENT, ARROWLOOSE_EVENT, ARROWNOCK_EVENT, ATTACKENTITY_EVENT, BONEMEAL_EVENT, ENTITYINTERACT_EVENT, ENTITYITEMPICKUP_EVENT, FILLBUCKET_EVENT, ITEMTOOLTIP_EVENT, PLAYERDESTROYITEM_EVENT, PLAYERDROPS_EVENT, PLAYER_EVENT, PLAYER_EVENT_BREAKSPEED, PLAYER_EVENT_CLONE, PLAYER_EVENT_HARVESTCHECK, PLAYER_EVENT_LOADFROMFILE, PLAYER_EVENT_NAMEFORMAT, PLAYER_EVENT_SAVETOFILE, PLAYER_EVENT_STARTTRACKING, PLAYER_EVENT_STOPTRACKING, PLAYERFLYABLEFALL_EVENT, PLAYERINTERACT_EVENT, PLAYEROPENCONTAINER_EVENT, PLAYERPICKUPXP_EVENT, PLAYERSETSPAWN_EVENT, PLAYERSLEEPINBED_EVENT, PLAYERUSEITEM_EVENT, PLAYERUSEITEM_EVENT_FINISH, PLAYERUSEITEM_EVENT_START, PLAYERUSEITEM_EVENT_STOP, PLAYERUSEITEM_EVENT_TICK, PLAYERWAKEUP_EVENT, SLEEPINGLOCATIONCHECK_EVENT, USEHOE_EVENT
	}

	public static void logEventCounts(){
		if (eventCounting) {
			for (Map.Entry<LocalEventId, LocalEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}
			
		}

	}

	public EntityPlayerEventHandler() {
		LogHelper.info("Entity Player Event Handler has been setup");
		localEvents.put(LocalEventId.ACHIEVEMENT_EVENT, new LocalEvent("Achievement", true));
		localEvents.put(LocalEventId.ANVILREPAIR_EVENT, new LocalEvent("Anvil Repair", true));
		localEvents.put(LocalEventId.ARROWLOOSE_EVENT, new LocalEvent("Arrow Loose", true));
		localEvents.put(LocalEventId.ARROWNOCK_EVENT, new LocalEvent("Arrow Nock", true));
		localEvents.put(LocalEventId.ATTACKENTITY_EVENT, new LocalEvent("Attack Entity", true));
		localEvents.put(LocalEventId.BONEMEAL_EVENT, new LocalEvent("Bonemeal", true));
		localEvents.put(LocalEventId.ENTITYINTERACT_EVENT, new LocalEvent("Entity Interact", true));
		localEvents.put(LocalEventId.ENTITYITEMPICKUP_EVENT, new LocalEvent("Entity Item Pickup", true));
		localEvents.put(LocalEventId.FILLBUCKET_EVENT, new LocalEvent("Fill Bucket", true));
		localEvents.put(LocalEventId.ITEMTOOLTIP_EVENT, new LocalEvent("Item Tooltip", true));
		localEvents.put(LocalEventId.PLAYERDESTROYITEM_EVENT, new LocalEvent("Player Destroy Item", true));
		localEvents.put(LocalEventId.PLAYERDROPS_EVENT, new LocalEvent("Player Drops", true));
		localEvents.put(LocalEventId.PLAYER_EVENT, new LocalEvent("Player", false));
		localEvents.put(LocalEventId.PLAYER_EVENT_BREAKSPEED, new LocalEvent("Player - Break Speed", true));
		localEvents.put(LocalEventId.PLAYER_EVENT_CLONE, new LocalEvent("Player - Clone", true));
		localEvents.put(LocalEventId.PLAYER_EVENT_HARVESTCHECK, new LocalEvent("Player - Harvest Check", true));
		localEvents.put(LocalEventId.PLAYER_EVENT_LOADFROMFILE, new LocalEvent("Player - Load From File", true));
		localEvents.put(LocalEventId.PLAYER_EVENT_NAMEFORMAT, new LocalEvent("Player - Name Format", true));
		localEvents.put(LocalEventId.PLAYER_EVENT_SAVETOFILE, new LocalEvent("Player - Save To File", true));
		localEvents.put(LocalEventId.PLAYER_EVENT_STARTTRACKING, new LocalEvent("Player - Start Tracking", false));
		localEvents.put(LocalEventId.PLAYER_EVENT_STOPTRACKING, new LocalEvent("Player - Stop Tracking", true));
		localEvents.put(LocalEventId.PLAYERFLYABLEFALL_EVENT, new LocalEvent("Player Flyable Fall", true));
		localEvents.put(LocalEventId.PLAYERINTERACT_EVENT, new LocalEvent("Player Interact", true));
		localEvents.put(LocalEventId.PLAYEROPENCONTAINER_EVENT, new LocalEvent("Player Open Container", false));
		localEvents.put(LocalEventId.PLAYERPICKUPXP_EVENT, new LocalEvent("Player Pickup Xp", true));
		localEvents.put(LocalEventId.PLAYERSETSPAWN_EVENT, new LocalEvent("Player Set Spawn", true));
		localEvents.put(LocalEventId.PLAYERSLEEPINBED_EVENT, new LocalEvent("Player Sleep In Bed", true));
		localEvents.put(LocalEventId.PLAYERUSEITEM_EVENT, new LocalEvent("Player Use Item", true));
		localEvents.put(LocalEventId.PLAYERUSEITEM_EVENT_FINISH, new LocalEvent("Player Use Item - Finish", true));
		localEvents.put(LocalEventId.PLAYERUSEITEM_EVENT_START, new LocalEvent("Player Use Item - Start", true));
		localEvents.put(LocalEventId.PLAYERUSEITEM_EVENT_STOP, new LocalEvent("Player Use Item - Stop", true));
		localEvents.put(LocalEventId.PLAYERUSEITEM_EVENT_TICK, new LocalEvent("Player Use Item - Tick", true));
		localEvents.put(LocalEventId.PLAYERWAKEUP_EVENT, new LocalEvent("Player Wake Up", true));
		localEvents.put(LocalEventId.SLEEPINGLOCATIONCHECK_EVENT, new LocalEvent("Sleeping Location Check", true));
		localEvents.put(LocalEventId.USEHOE_EVENT, new LocalEvent("Use Hoe", true));
	}

	/*
	 * AchievementEvent When the player receives an achievement.
	 * 
	 */
	@SubscribeEvent
	public void achievementEvent(AchievementEvent event) {
		currentEvent = LocalEventId.ACHIEVEMENT_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * AnvilRepairEvent
	 */
	@SubscribeEvent
	public void anvilRepairEvent(AnvilRepairEvent event) {
		currentEvent = LocalEventId.ANVILREPAIR_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
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
		currentEvent = LocalEventId.ARROWLOOSE_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
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
		currentEvent = LocalEventId.ARROWNOCK_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
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
		currentEvent = LocalEventId.ATTACKENTITY_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);

	}

	/*
	 * BonemealEvent
	 */
	@SubscribeEvent
	public void bonemealEvent(BonemealEvent event) {
		currentEvent = LocalEventId.BONEMEAL_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
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
		currentEvent = LocalEventId.ENTITYINTERACT_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);

	}

	/*
	 * EntityItemPickupEvent
	 */
	@SubscribeEvent
	public void entityItemPickupEvent(EntityItemPickupEvent event) {
		currentEvent = LocalEventId.ENTITYITEMPICKUP_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * FillBucketEvent
	 */
	@SubscribeEvent
	public void fillBucketEvent(FillBucketEvent event) {
		currentEvent = LocalEventId.FILLBUCKET_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * ItemTooltipEvent
	 */
	@SubscribeEvent
	public void itemTooltipEvent(ItemTooltipEvent event) {
		currentEvent = LocalEventId.ITEMTOOLTIP_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);

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
		currentEvent = LocalEventId.PLAYERDESTROYITEM_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerDropsEvent Child class of LivingDropEvent that is fired
	 * specifically when a player dies.
	 */
	@SubscribeEvent
	public void playerDropsEvent(PlayerDropsEvent event) {
		currentEvent = LocalEventId.PLAYERDROPS_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerEvent PlayerEvent is fired whenever an event involving Living
	 * entities occurs.
	 */
	@SubscribeEvent
	public void playerEvent(PlayerEvent event) {
		currentEvent = LocalEventId.PLAYER_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);

	}

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
		currentEvent = LocalEventId.PLAYER_EVENT_BREAKSPEED;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);

	}

	/*
	 * PlayerEvent.Clone Fired when the EntityPlayer is cloned, typically caused
	 * by the network sending a RESPAWN_PLAYER event.
	 */
	@SubscribeEvent
	public void playerEventClone(PlayerEvent.Clone event) {
		currentEvent = LocalEventId.PLAYER_EVENT_CLONE;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
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
		currentEvent = LocalEventId.PLAYER_EVENT_HARVESTCHECK;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerEvent.LoadFromFile The player is being loaded from the world save.
	 */
	@SubscribeEvent
	public void playerEventLoadFromFile(PlayerEvent.LoadFromFile event) {
		currentEvent = LocalEventId.PLAYER_EVENT_LOADFROMFILE;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
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
		currentEvent = LocalEventId.PLAYER_EVENT_NAMEFORMAT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerEvent.SaveToFile The player is being saved to the world store.
	 */
	@SubscribeEvent
	public void playerEventSaveToFile(PlayerEvent.SaveToFile event) {
		currentEvent = LocalEventId.PLAYER_EVENT_SAVETOFILE;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerEvent.StartTracking Fired when an Entity is started to be "tracked"
	 * by this player (the player receives updates about this entity, e.g.
	 */
	@SubscribeEvent
	public void playerEventStartTracking(PlayerEvent.StartTracking event) {
		currentEvent = LocalEventId.PLAYER_EVENT_STARTTRACKING;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerEvent.StopTracking Fired when an Entity is stopped to be "tracked"
	 * by this player (the player no longer receives updates about this entity,
	 * e.g.
	 */
	@SubscribeEvent
	public void playerEventStopTracking(PlayerEvent.StopTracking event) {
		currentEvent = LocalEventId.PLAYER_EVENT_STOPTRACKING;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerFlyableFallEvent Occurs when a player falls, but is able to fly.
	 */
	@SubscribeEvent
	public void playerFlyableFallEvent(PlayerFlyableFallEvent event) {
		currentEvent = LocalEventId.PLAYERFLYABLEFALL_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerInteractEventEvent PlayerInteractEventEvent is fired when a player
	 * public interacts in some way.
	 */
	@SubscribeEvent
	public void playerInteractEvent(PlayerInteractEvent event) {
		currentEvent = LocalEventId.PLAYERINTERACT_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerOpenContainerEvent
	 */
	@SubscribeEvent
	public void playerOpenContainerEvent(PlayerOpenContainerEvent event) {
		currentEvent = LocalEventId.PLAYEROPENCONTAINER_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerPickupXpEvent This event is called when a player collides with a
	 * EntityXPOrb on the ground.
	 */
	@SubscribeEvent
	public void playerPickupXpEvent(PlayerPickupXpEvent event) {
		currentEvent = LocalEventId.PLAYERPICKUPXP_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerSetSpawnEvent
	 */
	@SubscribeEvent
	public void playerSetSpawnEvent(PlayerSetSpawnEvent event) {
		currentEvent = LocalEventId.PLAYERSETSPAWN_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerSleepInBedEvent PlayerSleepInBedEvent is fired when a player sleeps
	 * in a bed.
	 */
	@SubscribeEvent
	public void playerSleepInBedEvent(PlayerSleepInBedEvent event) {
		currentEvent = LocalEventId.PLAYERSLEEPINBED_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerUseItemEvent
	 */
	@SubscribeEvent
	public void playerUseItemEvent(PlayerUseItemEvent event) {
		currentEvent = LocalEventId.PLAYERUSEITEM_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerUseItemEvent.Finish Fired after an item has fully finished being
	 * used.
	 */
	@SubscribeEvent
	public void playerUseItemEventFinish(PlayerUseItemEvent.Finish event) {
		currentEvent = LocalEventId.PLAYERUSEITEM_EVENT_FINISH;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerUseItemEvent.Start Fired when a player starts 'using' an item,
	 * typically when they hold right mouse.
	 */
	@SubscribeEvent
	public void playerUseItemEventStart(PlayerUseItemEvent.Start event) {
		currentEvent = LocalEventId.PLAYERUSEITEM_EVENT_START;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerUseItemEvent.Stop Fired when a player stops using an item without
	 * the use duration timing out.
	 */
	@SubscribeEvent
	public void playerUseItemEventStop(PlayerUseItemEvent.Stop event) {
		currentEvent = LocalEventId.PLAYERUSEITEM_EVENT_STOP;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerUseItemEvent.Tick Fired every tick that a player is 'using' an
	 * item, see PlayerUseItemEvent.Start for info.
	 */
	@SubscribeEvent
	public void playerUseItemEventTick(PlayerUseItemEvent.Tick event) {
		currentEvent = LocalEventId.PLAYERUSEITEM_EVENT_TICK;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * PlayerWakeUpEvent This event is fired when the player is waking up. This
	 * is merely for purposes of listening for this to happen. There is nothing
	 * that can be manipulated with this event.
	 */
	@SubscribeEvent
	public void playerWakeUpEvent(PlayerWakeUpEvent event) {
		currentEvent = LocalEventId.PLAYERWAKEUP_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * SleepingLocationCheckEvent This event is fired when game checks, if
	 * sleeping player should be still considered "in bed". Failing this check
	 * will cause player to wake up. This event has a result.
	 */
	@SubscribeEvent
	public void sleepingLocationCheckEvent(SleepingLocationCheckEvent event) {
		currentEvent = LocalEventId.SLEEPINGLOCATIONCHECK_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);
	}

	/*
	 * UseHoeEvent
	 */
	@SubscribeEvent
	public void useHoeEvent(UseHoeEvent event) {
		currentEvent = LocalEventId.USEHOE_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEvent);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEvent, thisEvent);

	}

}
