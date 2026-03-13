package org.nahulemes.pom.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TicketDataFactory {

    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    private TicketDataFactory() {
    }

    public static String uniqueTitle() {
        return "AUTO-TICKET-" + LocalDateTime.now().format(TIMESTAMP_FORMAT);
    }

    public static String descriptionFor(String title) {
        return "Automatically created ticket for E2E validation: " + title;
    }
}
