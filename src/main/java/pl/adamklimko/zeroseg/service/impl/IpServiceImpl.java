package pl.adamklimko.zeroseg.service.impl;

import org.springframework.stereotype.Service;
import pl.adamklimko.zeroseg.model.Ip;

@Service
public class IpServiceImpl {
    private Ip ip;

    public Ip getIp() {
        return ip;
    }

    public void setIp(Ip ip) {
        this.ip = ip;
    }
}
