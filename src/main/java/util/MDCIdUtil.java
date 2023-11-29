package util;

import org.slf4j.MDC;

import java.util.UUID;

/**
 * @ClassName: MDCIdUtil util
 * @Description: CID CID
 * @Author: ice
 */
public class MDCIdUtil {

    public static final String CID = "cid";

    private MDCIdUtil() {
    }

    public static void putIfAbsent() {
        if (StringUtils.isBlank(get())) {
            put(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        }
    }

    public static void remove() {
        if (get() != null) {
            MDC.remove(CID);
        }
    }

    public static String generateCid() {
        if (StringUtils.isNotBlank(get())) {
            return MDC.get(CID);
        }
        String cid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        put(cid);
        return cid;
    }

    public static String get() {
        return MDC.get(CID);
    }

    public static void put(String cid) {
        MDC.put(CID, cid);
    }
}
