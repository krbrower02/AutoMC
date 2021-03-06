package my.krbmod.automc.eventhandler;

import my.krbmod.automc.aisystem.status.WorldStatusMonitor;
import my.krbmod.automc.utility.LogHelper;
import my.krbmod.automc.utility.ModTime;
import my.krbmod.automc.utility.TimeString;

public class MFEvent {
	private String name;
	private boolean logEvent;
	private long lastEventTime = 0;
	private int eventCounter = 0;

	public MFEvent() {
		this("Unknown", false);
	}

	public MFEvent(String name, boolean logEvent) {
		this.name = name;
		this.logEvent = logEvent;
		this.lastEventTime = 0;
		this.eventCounter = 0;
	}

	public String eventStamp() {
		return (String.format(": %s %d event%s [Last call: %s]", name, eventCounter, (eventCounter == 1) ? "" : "s",
				elapsedString()));
	}

	public String elapsedString() {
		if (lastEventTime == 0) {
			return "None";
		} else {
			return ModTime.millisToString(Math.abs((System.currentTimeMillis() - lastEventTime)));
		}

	}

	public int elapsedInt() {
		if (lastEventTime == 0) {
			return -1;
		} else {
			return (int) Math.abs(System.currentTimeMillis() - lastEventTime);
		}

	}

	public String getEventName() {
		return this.name;
	}

	public void setLogEvent() {
		this.logEvent = true;
	}

	public void clearLogEvent() {
		this.logEvent = false;
	}

	public void logEvent(boolean count, boolean log) {
		if (WorldStatusMonitor.isChunkLoadingFinished()) {  // Track events that occur after Chunk Loading has completed

			if (count) {
				eventCounter++;
			}
			if (log) {
				lastEventTime = System.currentTimeMillis();
				if (logEvent) {
					LogHelper.info("[" + name + "]");
				}
			}
		}

	}

	public int getEventCounter() {
		return this.eventCounter;
	}

	public long getLastEventTime() {
		return this.lastEventTime;
	}

}
