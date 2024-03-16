package com.devsuperior.dsmovie.config.swagger;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devsuperior.dsmovie.dto.CustomErrorDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SwaggerAnnotationScore {

	@Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Operation(
		    description = "Save score",
		    summary = "Save score",
		    responses = {
		    	 @ApiResponse(description = "Bad Request", responseCode = "400"),
		         @ApiResponse(description = "Created", responseCode = "201"),
		         @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
		         @ApiResponse(description = "Unauthorized", responseCode = "401" , content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
		         @ApiResponse(description = "Forbidden", responseCode = "403",  content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
		         @ApiResponse(description = "Unprocessable Entity", responseCode = "422" ,  content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
		    }
		)
	 @RequestMapping(value = "/scores", method = RequestMethod.PUT, produces = "application/json")
	 @interface saveScoreSwagger {
    }
}
