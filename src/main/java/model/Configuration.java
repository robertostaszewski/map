package model;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

public class Configuration {
    private String map;
    private BigDecimal constVariable;
    private BigDecimal xConst;
    private BigDecimal yConst;

    private static Configuration CONFIG;

    private Configuration(String map, BigDecimal constVariable, BigDecimal xConst, BigDecimal yConst) {
        this.map = map;
        this.constVariable = constVariable;
        this.xConst = xConst;
        this.yConst = yConst;
    }

    public String getMap() {
        return map;
    }

    public BigDecimal getConstVariable() {
        return constVariable;
    }

    public BigDecimal getxConst() {
        return xConst;
    }

    public BigDecimal getyConst() {
        return yConst;
    }

    public static Configuration getInstance() {
        if (CONFIG == null) {
            initializeConfig();
        }
        return CONFIG;
    }

    private static void initializeConfig() {
        Properties properties = new Properties();
        try (InputStream in = Configuration.class.getClassLoader().getResourceAsStream("Application.properties")) {
            properties.load(in);
            CONFIG = new Configuration(
                    properties.getProperty("map"),
                    BigDecimal.valueOf(Double.parseDouble(properties.getProperty("constVariable"))),
                    BigDecimal.valueOf(Double.parseDouble(properties.getProperty("xConst"))),
                    BigDecimal.valueOf(Double.parseDouble(properties.getProperty("yConst"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
