package com.dwk.addition;
import carpet.CarpetExtension;
import carpet.CarpetServer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

public class DwkExtension implements CarpetExtension {
    public static void noop() { }
    static { CarpetServer.manageExtension(new DwkExtension()); }
    @Override public void onGameStarted() { CarpetServer.settingsManager.parseSettingsClass(DwkSettings.class); }
    @Override public String version() { return "1.0.0"; }
    @Override public Map<String, String> canHasTranslations(String lang) {
        String path = "assets/carpet-dwk-addition/lang/%s.json".formatted(lang);
        InputStream stream = DwkExtension.class.getClassLoader().getResourceAsStream(path);
        if (stream == null) return Collections.emptyMap();
        return new Gson().fromJson(new InputStreamReader(stream, StandardCharsets.UTF_8), new TypeToken<Map<String, String>>(){}.getType());
    }
}