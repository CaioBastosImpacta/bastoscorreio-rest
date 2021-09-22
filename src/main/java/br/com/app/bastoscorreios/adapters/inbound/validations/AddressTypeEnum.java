package br.com.app.bastoscorreios.adapters.inbound.validations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Optional;

@AllArgsConstructor
@Getter
public enum AddressTypeEnum {

    REST_TEMPLATE("rest-template"),
    WEB_FLUX("web_flux"),
    FEIGN_CLIENT("feign_client");

    private String type;

    public static Optional<String> verifyTypeValid(String type) {

        if (StringUtils.hasLength(type)) {
            for (AddressTypeEnum typeEnum : values()) {
                if (typeEnum.getType().equalsIgnoreCase(type)) {
                    return Optional.ofNullable(type);
                }
            }
        }

        return Optional.empty();
    }
}
