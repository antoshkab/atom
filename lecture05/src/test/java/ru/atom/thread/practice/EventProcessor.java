package ru.atom.thread.practice;

import java.util.List;

/**
 * @author apomosov
 * @since 15.03.17
 */
public class EventProcessor {
    public static void produceEvents(List<EventProducer> eventProducers) {
       eventProducers.forEach(eventProducer -> new Thread(eventProducer).run());
    }

    public static long countTotalNumberOfGoodEvents() {
        return EventQueue.getInstance().parallelStream().filter(event -> event.getEventType() == Event.EventType.GOOD).count();
    }

    public static long countTotalNumberOfBadEvents() {
        return EventQueue.getInstance().parallelStream().filter(event -> event.getEventType() == Event.EventType.BAD).count();
    }
}
