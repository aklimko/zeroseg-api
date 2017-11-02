package pl.adamklimko.zeroseg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.adamklimko.zeroseg.model.Ip;
import pl.adamklimko.zeroseg.service.impl.IpServiceImpl;

@RestController
@RequestMapping("/ip")
public class IpController {
    private final IpServiceImpl is;

    @Autowired
    public IpController(IpServiceImpl is) {
        this.is = is;
    }

    @GetMapping()
    public Ip getIp() {
        return is.getIp();
    }

    @PutMapping()
    public Ip setIp(@RequestBody Ip ip) {
        is.setIp(ip);
        return ip;
    }
}
