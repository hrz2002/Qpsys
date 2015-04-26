package framework.common;

import java.util.*;
import java.util.logging.*;

import framework.common.MessageUtility.*;

public final class LoggerManager {

    static {
        instance = new LoggerManager();
        // Frameworkライブラリのバージョン情報がログに出力されるように。
//        EducomFrameworkLibraryContext.getInstance();
    }

    private LoggerManager() {
    }

    /**
     * Gets the singleton instance of this class.
     *
     * @return The singleton instance of LoggerManager.
     */
    public static LoggerManager getInstance() {
        return instance;
    }

    /**
     * <p>
     * Gets a <code>Logger</code> to use in specified class.
     * </p>
     *
     * @param clazz The class which uses returned Logger.
     * @return A <code>Logger</code> to use in specified class.
     */
    public Logger getLogger(final Class<?> clazz) {
        return Logger.getLogger(clazz.getName());
    }

    /**
     * <p>
     * Gets a <code>Logger</code> to use in specified class.
     * </p>
     *
     * @param clazz The class which uses returned Logger.
     * @param resourceFileNameProvider {@link ResourceBundle} のファイル名。<code>null</code> を指定することは {@link ResourceFileNameProvider#DEFAULT} を指定することと同義。
     * @return A <code>Logger</code> to use in specified class.
     */
    public Logger getLogger(final Class<?> clazz, final ResourceFileNameProvider resourceFileNameProvider) {
        return Logger.getLogger(clazz.getName(), MessageUtility.getResourceFileName(resourceFileNameProvider == null ? ResourceFileNameProvider.DEFAULT : resourceFileNameProvider, clazz));
    }

    private static final LoggerManager instance;
}