package my.krbmod.automc.events.player;

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

public class PlayerEventHookContainer {

	boolean eventCounting = true;
	boolean eventLogging = true;

	public PlayerEventHookContainer() {
		LogHelper.info("Player Event Hooks has been setup");
	}

	/*
	 * AchievementEvent When the player receives an achievement.
	 * 
	 */
	public int achievementEventCounter;

	@SubscribeEvent
	public void achievementEvent(AchievementEvent event) {
		if (eventCounting) {
			achievementEventCounter++;
		}
		LogHelper.info("AchievementEvent");
	}

	/*
	 * AnvilRepairEvent
	 */
	public int anvilRepairEventCounter;

	@SubscribeEvent
	public void anvilRepairEvent(AnvilRepairEvent event) {
		if (eventCounting) {
			anvilRepairEventCounter++;
		}
		LogHelper.info("AnvilRepairEvent");
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
	public int arrowLooseEventCounter;

	@SubscribeEvent
	public void arrowLooseEvent(ArrowLooseEvent event) {
		if (eventCounting) {
			arrowLooseEventCounter++;
		}
		LogHelper.info("ArrowLooseEvent");
	}

	/*
	 * ArrowNockEvent ArrowNockEvent is fired when a player begins using a bow.
	 * This event is fired whenever a player begins using a bow in
	 * ItemBow#onItemRightClick(ItemStack, World, EntityPlayer).
	 * 
	 * ArrowNockEvent.result contains the resulting ItemStack due to the use of
	 * the bow.
	 */
	public int arrowNockEventCounter;

	@SubscribeEvent
	public void arrowNockEvent(ArrowNockEvent event) {
		if (eventCounting) {
			arrowNockEventCounter++;
		}
		LogHelper.info("ArrowNockEvent");
	}

	/*
	 * AttackEntityEvent AttackEntityEvent is fired when a player attacks an
	 * Entity. This event is fired whenever a player attacks an Entity in
	 * EntityPlayer#attackTargetEntityWithCurrentItem(Entity).
	 * 
	 * AttackEntityEvent.target contains the Entity that was damaged by the
	 * player.
	 */
	public int attackEntityEventCounter;

	@SubscribeEvent
	public void attackEntityEvent(AttackEntityEvent event) {
		if (eventCounting) {
			attackEntityEventCounter++;
		}
		LogHelper.info("AttackEntityEvent");
	}

	/*
	 * BonemealEvent
	 */
	public int bonemealEventCounter;

	@SubscribeEvent
	public void bonemealEvent(BonemealEvent event) {
		if (eventCounting) {
			bonemealEventCounter++;
		}
		LogHelper.info("BonemealEvent");
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
	public int entityInteractEventCounter;

	@SubscribeEvent
	public void entityInteractEvent(EntityInteractEvent event) {
		if (eventCounting) {
			entityInteractEventCounter++;
		}
		LogHelper.info("EntityInteractEvent");
	}

	/*
	 * EntityItemPickupEvent
	 */
	public int entityItemPickupEventCounter;

	@SubscribeEvent
	public void entityItemPickupEvent(EntityItemPickupEvent event) {
		if (eventCounting) {
			entityItemPickupEventCounter++;
		}
		LogHelper.info("EntityItemPickupEvent");
	}

	/*
	 * FillBucketEvent
	 */
	public int fillBucketEventCounter;

	@SubscribeEvent
	public void fillBucketEvent(FillBucketEvent event) {
		if (eventCounting) {
			fillBucketEventCounter++;
		}
		LogHelper.info("FillBucketEvent");
	}

	/*
	 * ItemTooltipEvent
	 */
	public int itemTooltipEventCounter;

	@SubscribeEvent
	public void itemTooltipEvent(ItemTooltipEvent event) {
		if (eventCounting) {
			itemTooltipEventCounter++;
		}
		LogHelper.info("ItemTooltipEvent");
	}

	/*
	 * PlayerDestroyItemEvent PlayerDestroyItemEvent is fired when a player
	 * destroys an item. This event is fired whenever a player destroys an item
	 * in PlayerControllerMP#onPlayerRightClick(EntityPlayer, World, ItemStack,
	 *  int,  int,  int,  int, Vec3),
	 * PlayerControllerMP#sendUseItem(EntityPlayer, World, ItemStack),
	 * EntityPlayer#destroyCurrentEquippedItem(),
	 * SlotCrafting#onPickupFromSlot(EntityPlayer, ItemStack),
	 * ItemInWorldManager#tryUseItem(EntityPlayer, World, ItemStack), and
	 * ItemInWorldManager#activateBlockOrUseItem(EntityPlayer, World, ItemStack,
	 *  int,  int,  int,  int, float, float, float).
	 * 
	 * PlayerDestroyItemEvent.original contains the original ItemStack before
	 * the item was destroyed.
	 */
	public int playerDestroyItemEventCounter;

	@SubscribeEvent
	public void playerDestroyItemEvent(PlayerDestroyItemEvent event) {
		if (eventCounting) {
			playerDestroyItemEventCounter++;
		}
		LogHelper.info("PlayerDestroyItemEvent");
	}

	/*
	 * PlayerDropsEvent Child class of LivingDropEvent that is fired
	 * specifically when a player dies.
	 */
	public int playerDropsEventCounter;

	@SubscribeEvent
	public void playerDropsEvent(PlayerDropsEvent event) {
		if (eventCounting) {
			playerDropsEventCounter++;
		}
		LogHelper.info("PlayerDropsEvent");
	}

	/*
	 * PlayerEvent PlayerEvent is fired whenever an event involving Living
	 * entities occurs.
	 */
	public int playerEventCounter;

	@SubscribeEvent
	public void playerEvent(PlayerEvent event) {
		if (eventCounting) {
			playerEventCounter++;
		}		
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
	public int playerEventBreakSpeedCounter;

	@SubscribeEvent
	public void playerEventBreakSpeed(PlayerEvent.BreakSpeed event) {
		if (eventCounting) {
			playerEventBreakSpeedCounter++;
		}
		LogHelper.info("PlayerEvent.BreakSpeed");
	}

	/*
	 * PlayerEvent.Clone Fired when the EntityPlayer is cloned, typically caused
	 * by the network sending a RESPAWN_PLAYER event.
	 */
	public int playerEventCloneCounter;

	@SubscribeEvent
	public void playerEventClone(PlayerEvent.Clone event) {
		if (eventCounting) {
			playerEventCloneCounter++;
		}
		LogHelper.info("PlayerEvent.Clone");
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
	public int playerEventHarvestCheckCounter;

	@SubscribeEvent
	public void playerEventHarvestCheck(PlayerEvent.HarvestCheck event) {
		if (eventCounting) {
			playerEventHarvestCheckCounter++;
		}
		LogHelper.info("PlayerEvent.HarvestCheck");
	}

	/*
	 * PlayerEvent.LoadFromFile The player is being loaded from the world save.
	 */
	public int playerEventLoadFromFileCounter;

	@SubscribeEvent
	public void playerEventLoadFromFile(PlayerEvent.LoadFromFile event) {
		if (eventCounting) {
			playerEventLoadFromFileCounter++;
		}
		LogHelper.info("PlayerEvent.LoadFromFile");
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
	public int playerEventNameFormatCounter;

	@SubscribeEvent
	public void playerEventNameFormat(PlayerEvent.NameFormat event) {
		if (eventCounting) {
			playerEventNameFormatCounter++;
		}
		LogHelper.info("PlayerEvent.NameFormat");
	}

	/*
	 * PlayerEvent.SaveToFile The player is being saved to the world store.
	 */
	public int playerEventSaveToFileCounter;

	@SubscribeEvent
	public void playerEventSaveToFile(PlayerEvent.SaveToFile event) {
		if (eventCounting) {
			playerEventSaveToFileCounter++;
		}
		LogHelper.info("PlayerEvent.SaveToFile");
	}

	/*
	 * PlayerEvent.StartTracking Fired when an Entity is started to be "tracked"
	 * by this player (the player receives updates about this entity, e.g.
	 */
	public int playerEventStartTrackingCounter;

	@SubscribeEvent
	public void playerEventStartTracking(PlayerEvent.StartTracking event) {
		if (eventCounting) {
			playerEventStartTrackingCounter++;
		}
		LogHelper.info("PlayerEvent.StartTracking");
	}

	/*
	 * PlayerEvent.StopTracking Fired when an Entity is stopped to be "tracked"
	 * by this player (the player no longer receives updates about this entity,
	 * e.g.
	 */

	public int playerEventStopTrackingCounter;

	@SubscribeEvent
	public void playerEventStopTracking(PlayerEvent.StopTracking event) {
		if (eventCounting) {
			playerEventStopTrackingCounter++;
		}
		LogHelper.info("PlayerEvent.StopTracking");
	}

	/*
	 * PlayerFlyableFallEvent Occurs when a player falls, but is able to fly.
	 */
	public int playerFlyableFallEventCounter;

	@SubscribeEvent
	public void playerFlyableFallEvent(PlayerFlyableFallEvent event) {
		if (eventCounting) {
			playerFlyableFallEventCounter++;
		}
		LogHelper.info("PlayerFlyableFallEvent");
	}

	/*
	 * PlayerInteractEventEvent PlayerInteractEventEvent is fired when a player
	 * public interacts in some way.
	 */
	public int playerInteractEventCounter;

	@SubscribeEvent
	public void playerInteractEvent(PlayerInteractEvent event) {
		if (eventCounting) {
			playerInteractEventCounter++;
		}
		LogHelper.info("PlayerInteractEvent");
	}

	/*
	 * PlayerOpenContainerEvent
	 */
	public int playerOpenContainerEventCounter;

	@SubscribeEvent
	public void playerOpenContainerEvent(PlayerOpenContainerEvent event) {
		if (eventCounting) {
			playerOpenContainerEventCounter++;
		}		
	}

	/*
	 * PlayerPickupXpEvent This event is called when a player collides with a
	 * EntityXPOrb on the ground.
	 */
	public int playerPickupXpEventCounter;

	@SubscribeEvent
	public void playerPickupXpEvent(PlayerPickupXpEvent event) {
		if (eventCounting) {
			playerPickupXpEventCounter++;
		}
		LogHelper.info("PlayerPickupXpEvent");
	}

	/*
	 * PlayerSetSpawnEvent
	 */
	public int playerSetSpawnEventCounter;

	@SubscribeEvent
	public void playerSetSpawnEvent(PlayerSetSpawnEvent event) {
		if (eventCounting) {
			playerSetSpawnEventCounter++;
		}
		LogHelper.info("PlayerSetSpawnEvent");
	}

	/*
	 * PlayerSleepInBedEvent PlayerSleepInBedEvent is fired when a player sleeps
	 * in a bed.
	 */
	public int playerSleepInBedEventCounter;

	@SubscribeEvent
	public void playerSleepInBedEvent(PlayerSleepInBedEvent event) {
		if (eventCounting) {
			playerSleepInBedEventCounter++;
		}
		LogHelper.info("PlayerSleepInBedEvent");
	}

	/*
	 * PlayerUseItemEvent
	 */
	public int playerUseItemEventCounter;

	@SubscribeEvent
	public void playerUseItemEvent(PlayerUseItemEvent event) {
		if (eventCounting) {
			playerUseItemEventCounter++;
		}
		LogHelper.info("PlayerUseItemEvent");
	}

	/*
	 * PlayerUseItemEvent.Finish Fired after an item has fully finished being
	 * used.
	 */
	public int playerUseItemEventFinishCounter;

	@SubscribeEvent
	public void playerUseItemEventFinish(PlayerUseItemEvent.Finish event) {
		if (eventCounting) {
			playerUseItemEventFinishCounter++;
		}
		LogHelper.info("PlayerUseItemEvent.Finish");
	}

	/*
	 * PlayerUseItemEvent.Start Fired when a player starts 'using' an item,
	 * typically when they hold right mouse.
	 */
	public int playerUseItemEventStartCounter;

	@SubscribeEvent
	public void playerUseItemEventStart(PlayerUseItemEvent.Start event) {
		if (eventCounting) {
			playerUseItemEventStartCounter++;
		}
		LogHelper.info("PlayerUseItemEvent.Start");
	}

	/*
	 * PlayerUseItemEvent.Stop Fired when a player stops using an item without
	 * the use duration timing out.
	 */
	public int playerUseItemEventStopCounter;
	@SubscribeEvent
	public void playerUseItemEventStop(PlayerUseItemEvent.Stop event) {
		if (eventCounting) {
			playerUseItemEventStopCounter++;
		}
		LogHelper.info("PlayerUseItemEvent.Stop");
	}

	/*
	 * PlayerUseItemEvent.Tick Fired every tick that a player is 'using' an
	 * item, see PlayerUseItemEvent.Start for info.
	 */
	public int playerUseItemEventTickCounter;

	@SubscribeEvent
	public void playerUseItemEventTick(PlayerUseItemEvent.Tick event) {
		if (eventCounting) {
			playerUseItemEventTickCounter++;
		}
		LogHelper.info("PlayerUseItemEvent.Tick");
	}

	/*
	 * PlayerWakeUpEvent This event is fired when the player is waking up. This
	 * is merely for purposes of listening for this to happen. There is nothing
	 * that can be manipulated with this event.
	 */
	public int playerWakeUpEventCounter;

	@SubscribeEvent
	public void playerWakeUpEvent(PlayerWakeUpEvent event) {
		if (eventCounting) {
			playerWakeUpEventCounter++;
		}
		LogHelper.info("PlayerWakeUpEvent");
	}

	/*
	 * SleepingLocationCheckEvent This event is fired when game checks, if
	 * sleeping player should be still considered "in bed". Failing this check
	 * will cause player to wake up. This event has a result.
	 */
	public int sleepingLocationCheckEventCounter;

	@SubscribeEvent
	public void sleepingLocationCheckEvent(SleepingLocationCheckEvent event) {
		if (eventCounting) {
			sleepingLocationCheckEventCounter++;
		}
		LogHelper.info("SleepingLocationCheckEvent");
	}

	/*
	 * UseHoeEvent
	 */
	public int useHoeEventCounter;

	@SubscribeEvent
	public void useHoeEvent(UseHoeEvent event) {
		if (eventCounting) {
			useHoeEventCounter++;
		}
		LogHelper.info("UseHoeEvent");
	}

}
