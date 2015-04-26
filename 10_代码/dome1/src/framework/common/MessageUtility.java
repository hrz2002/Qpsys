package framework.common;

import java.text.*;
import java.util.*;
import java.util.logging.*;

final public class MessageUtility {

    /**
     * このClassのデフォルトの<code>Logger</code>取得する。
     * 特に理由のない限り、このClass内ではこのメソッドを通じてLoggerを取得することを推奨する。
     *
     * @return このClassのデフォルトの<code>Logger</code>
     */
    static private Logger getLogger() {
        final LoggerManager manager = LoggerManager.getInstance();
        final Logger logger = manager.getLogger(MessageUtility.class);
        return logger;
    }

    static public interface ResourceFileNameProvider {

        /**
         * デフォルトの「message」を返す実装。
         */
        static final public ResourceFileNameProvider DEFAULT = new ResourceFileNameProvider() {
            public String getResourceFileName() {
                return "message";
            }
        };

        String getResourceFileName();
    }

    static public String getResourceFileName(final ResourceFileNameProvider provider, final Class<?> clazz) {
        return String.format("%s.%s", clazz.getPackage().getName(), provider.getResourceFileName());
    }

    /**
     * <p>
     * message.properties ファイルを読み込み、与えられた列挙型の名称をキーとしてフォーマット文字列を取得し、与えられた引数でフォーマットされた文字列を返す。
     * </p>
     *
     * @param key
     * @param arguments
     * @return
     */
    static public String getMessage(final Enum<?> key, final Object... arguments) {
        try {
            final ResourceFileNameProvider resourceFileNameProvider = (key instanceof ResourceFileNameProvider ? ((ResourceFileNameProvider) key) : ResourceFileNameProvider.DEFAULT);
            final String resourceFileName = getResourceFileName(resourceFileNameProvider, key.getClass());
            final ResourceBundle bundle = ResourceBundle.getBundle(resourceFileName, Locale.JAPAN);
            final String string = bundle.getString(key.name());
            return arguments.length > 0 ? new MessageFormat(string, Locale.JAPAN).format(arguments) : string;
        } catch (final RuntimeException e) {
            final String msg = String.format("Failed to format message: %s#%s", key.getClass().getName(), key.toString());
            getLogger().logp(Level.WARNING, MessageUtility.class.getName(), "getMessage", msg, e);
            return arguments.length > 0 ? key.toString() + Arrays.toString(arguments) : key.toString();
        }
    }

    /**
     * 唯一のコンストラクタ。
     */
    private MessageUtility() {
        // インスタンス化を抑制
    }
}