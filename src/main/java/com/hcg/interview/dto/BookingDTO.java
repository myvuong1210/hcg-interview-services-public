package com.hcg.interview.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hcg.interview.entity.Guests;
import com.hcg.interview.entity.RatePlan;
import com.hcg.interview.entity.RoomType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {
        private RoomType roomType;
        private RatePlan ratePlan;
        private String startDate;
        private String endDate;
        private Guests guest;
}
