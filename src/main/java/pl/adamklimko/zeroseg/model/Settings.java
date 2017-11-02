package pl.adamklimko.zeroseg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.TreeMap;

@Entity
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;
    private Double waitTimeAfterClick;
    private Double displayRateClock;
    private Integer displayRateDate;
    private Integer displayRateWeather;
    private Integer displayRateCurrency;
    private Integer displayRateInstagram;
    private Integer updateRateWeather;
    private Integer updateRateCurrency;
    private Integer updateRateInstagram;
    private String urlWeather;
    private String urlEUR;
    private String urlUSD;
    private String urlInstagram;
    private TreeMap<Integer, Integer> hours;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getWaitTimeAfterClick() {
        return waitTimeAfterClick;
    }

    public void setWaitTimeAfterClick(Double waitTimeAfterClick) {
        this.waitTimeAfterClick = waitTimeAfterClick;
    }

    public Double getDisplayRateClock() {
        return displayRateClock;
    }

    public void setDisplayRateClock(Double displayRateClock) {
        this.displayRateClock = displayRateClock;
    }

    public Integer getDisplayRateDate() {
        return displayRateDate;
    }

    public void setDisplayRateDate(Integer displayRateDate) {
        this.displayRateDate = displayRateDate;
    }

    public Integer getDisplayRateWeather() {
        return displayRateWeather;
    }

    public void setDisplayRateWeather(Integer displayRateWeather) {
        this.displayRateWeather = displayRateWeather;
    }

    public Integer getDisplayRateCurrency() {
        return displayRateCurrency;
    }

    public void setDisplayRateCurrency(Integer displayRateCurrency) {
        this.displayRateCurrency = displayRateCurrency;
    }

    public Integer getDisplayRateInstagram() {
        return displayRateInstagram;
    }

    public void setDisplayRateInstagram(Integer displayRateInstagram) {
        this.displayRateInstagram = displayRateInstagram;
    }

    public Integer getUpdateRateWeather() {
        return updateRateWeather;
    }

    public void setUpdateRateWeather(Integer updateRateWeather) {
        this.updateRateWeather = updateRateWeather;
    }

    public Integer getUpdateRateCurrency() {
        return updateRateCurrency;
    }

    public void setUpdateRateCurrency(Integer updateRateCurrency) {
        this.updateRateCurrency = updateRateCurrency;
    }

    public Integer getUpdateRateInstagram() {
        return updateRateInstagram;
    }

    public void setUpdateRateInstagram(Integer updateRateInstagram) {
        this.updateRateInstagram = updateRateInstagram;
    }

    public String getUrlWeather() {
        return urlWeather;
    }

    public void setUrlWeather(String urlWeather) {
        this.urlWeather = urlWeather;
    }

    public String getUrlEUR() {
        return urlEUR;
    }

    public void setUrlEUR(String urlEUR) {
        this.urlEUR = urlEUR;
    }

    public String getUrlUSD() {
        return urlUSD;
    }

    public void setUrlUSD(String urlUSD) {
        this.urlUSD = urlUSD;
    }

    public String getUrlInstagram() {
        return urlInstagram;
    }

    public void setUrlInstagram(String urlInstagram) {
        this.urlInstagram = urlInstagram;
    }

    public void setHours(TreeMap<Integer, Integer> hours) {
        this.hours = hours;
    }

    public TreeMap<Integer, Integer> getHours() {
        return hours;
    }
}
