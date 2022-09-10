package net.sourcewriters.minecraft.phoenixui.util.color;

import java.util.regex.Pattern;

public final class BukkitColor {

    private BukkitColor() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static final char COLOR_CHAR = '\u00A7';
    public static final char REPLACEMENT_CHAR = '\u0026';
    public static final String ALL_CODES = "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx";
    public static final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)" + String.valueOf(COLOR_CHAR) + "[0-9A-FK-ORX]");
    public static final Pattern STRIP_UNCOLORED_PATTERN = Pattern.compile("(?i)" + String.valueOf(REPLACEMENT_CHAR) + "[0-9A-FK-ORX]");

    public static String strip(final String text) {
        return text == null ? null : STRIP_COLOR_PATTERN.matcher(text).replaceAll("");
    }

    public static String stripPlain(final String text) {
        return text == null ? null : STRIP_UNCOLORED_PATTERN.matcher(text).replaceAll("");
    }

    public static String apply(final String text) {
        final char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length - 1; ++i) {
            if (chars[i] == REPLACEMENT_CHAR && ALL_CODES.indexOf(chars[i + 1]) > -1) {
                chars[i] = COLOR_CHAR;
                chars[i + 1] = Character.toLowerCase(chars[i + 1]);
            }
        }
        return new String(chars);
    }

    public static String unapply(final String text) {
        final char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length - 1; ++i) {
            if (chars[i] == COLOR_CHAR && ALL_CODES.indexOf(chars[i + 1]) > -1) {
                chars[i] = REPLACEMENT_CHAR;
                chars[i + 1] = Character.toLowerCase(chars[i + 1]);
            }
        }
        return new String(chars);
    }
}