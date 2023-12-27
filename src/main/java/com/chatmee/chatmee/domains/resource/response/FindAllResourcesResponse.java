package com.chatmee.chatmee.domains.resource.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAllResourcesResponse {

    private String label;
    private String icon;
    private String routerLink;
    private String code;
}
