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
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SwaggerAnnotationMovie {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Operation(
		    description = "Get all movies",
		    summary = "Get all movies",
		    responses = {
		         @ApiResponse(description = "ok", responseCode = "200"),
		    })
    @RequestMapping(value = "/movies", method = RequestMethod.GET, produces = "application/json")
    @interface FindAllSwagger {
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Operation(
		    description = "Get movies by id",
		    summary = "Get movies by id",
		    responses = {
		         @ApiResponse(description = "ok", responseCode = "200"),
		         @ApiResponse(description = "Not found", responseCode = "404" , content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
		    })
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET, produces = "application/json")
    @interface FindByIdSwagger {
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Operation(
		    description = "Create a new movie",
		    summary = "Create a new movie",
		    responses = {
		         @ApiResponse(description = "Created", responseCode = "201"),
		         @ApiResponse(description = "Bad Request", responseCode = "400" , content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
		         @ApiResponse(description = "Unauthorized", responseCode = "401" , content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
		         @ApiResponse(description = "Forbidden", responseCode = "403" ,  content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
		         @ApiResponse(description = "Unprocessable Entity", responseCode = "422" ,  content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
		    })
    @RequestMapping(value = "/movies", method = RequestMethod.POST, produces = "application/json")
    @interface InsertSwagger {
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
	@Operation(description = "update a movie", summary = "update a movie", responses = {
			@ApiResponse(description = "No content", responseCode = "204"),
			@ApiResponse(description = "Not found", responseCode = "404", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
			@ApiResponse(description = "Forbidden", responseCode = "403" , content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))), })
	@SecurityRequirement(name = "bearerAuth") // Indica autenticação utilizando o esquema "Bearer Token"
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @interface deleteSwagger {
    }
    
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Operation(description = "update a movie", summary = "update a movie", responses = {
			@ApiResponse(description = "ok", responseCode = "200"),
			@ApiResponse(description = "Not found", responseCode = "404", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
			@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))),
			@ApiResponse(description = "Unprocessable Entity", responseCode = "422", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorDTO.class))), })
	@SecurityRequirement(name = "bearerAuth") // Indica autenticação utilizando o esquema "Bearer Token"	@SecurityRequirement(name = "bearerAuth") // Indica autenticação utilizando o esquema "Bearer Token"
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT, produces = "application/json")
    @interface updateSwagger {
    }
}
