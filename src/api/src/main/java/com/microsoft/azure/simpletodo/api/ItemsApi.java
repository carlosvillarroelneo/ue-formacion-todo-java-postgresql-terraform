/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.microsoft.azure.simpletodo.api;

import com.microsoft.azure.simpletodo.model.TodoItem;
import com.microsoft.azure.simpletodo.model.TodoState;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.math.BigDecimal;
import java.util.List;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "Items", description = "the Items API")
public interface ItemsApi {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /lists/{listId}/items : Creates a new Todo item within a list
     *
     * @param listId The Todo list unique identifier (required)
     * @param todoItem The Todo Item (optional)
     * @return A Todo item result (status code 201)
     *         or Todo list not found (status code 404)
     */
    @Operation(
        operationId = "createItem",
        summary = "Creates a new Todo item within a list",
        tags = { "Items" },
        responses = {
            @ApiResponse(
                responseCode = "201",
                description = "A Todo item result",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TodoItem.class)) }
            ),
            @ApiResponse(responseCode = "404", description = "Todo list not found"),
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/lists/{listId}/items",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<TodoItem> createItem(
        @Parameter(name = "listId", description = "The Todo list unique identifier", required = true) @PathVariable(
            "listId"
        ) String listId,
        @Parameter(name = "TodoItem", description = "The Todo Item") @Valid @RequestBody(required = false) TodoItem todoItem
    ) {
        getRequest()
            .ifPresent(request -> {
                for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString =
                            "{ \"listId\" : \"listId\", \"dueDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"completedDate\" : \"2000-01-23T04:56:07.000+00:00\" }";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * DELETE /lists/{listId}/items/{itemId} : Deletes a Todo item by unique identifier
     *
     * @param listId The Todo list unique identifier (required)
     * @param itemId The Todo item unique identifier (required)
     * @return Todo item deleted successfully (status code 204)
     *         or Todo list or item not found (status code 404)
     */
    @Operation(
        operationId = "deleteItemById",
        summary = "Deletes a Todo item by unique identifier",
        tags = { "Items" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Todo item deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Todo list or item not found"),
        }
    )
    @RequestMapping(method = RequestMethod.DELETE, value = "/lists/{listId}/items/{itemId}")
    default ResponseEntity<Void> deleteItemById(
        @Parameter(name = "listId", description = "The Todo list unique identifier", required = true) @PathVariable(
            "listId"
        ) String listId,
        @Parameter(name = "itemId", description = "The Todo item unique identifier", required = true) @PathVariable(
            "itemId"
        ) String itemId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * GET /lists/{listId}/items/{itemId} : Gets a Todo item by unique identifier
     *
     * @param listId The Todo list unique identifier (required)
     * @param itemId The Todo item unique identifier (required)
     * @return A Todo item result (status code 200)
     *         or Todo list or item not found (status code 404)
     */
    @Operation(
        operationId = "getItemById",
        summary = "Gets a Todo item by unique identifier",
        tags = { "Items" },
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "A Todo item result",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TodoItem.class)) }
            ),
            @ApiResponse(responseCode = "404", description = "Todo list or item not found"),
        }
    )
    @RequestMapping(method = RequestMethod.GET, value = "/lists/{listId}/items/{itemId}", produces = { "application/json" })
    default ResponseEntity<TodoItem> getItemById(
        @Parameter(name = "listId", description = "The Todo list unique identifier", required = true) @PathVariable(
            "listId"
        ) String listId,
        @Parameter(name = "itemId", description = "The Todo item unique identifier", required = true) @PathVariable(
            "itemId"
        ) String itemId
    ) {
        getRequest()
            .ifPresent(request -> {
                for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString =
                            "{ \"listId\" : \"listId\", \"dueDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"completedDate\" : \"2000-01-23T04:56:07.000+00:00\" }";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * GET /lists/{listId}/items : Gets Todo items within the specified list
     *
     * @param listId The Todo list unique identifier (required)
     * @param top The max number of items to returns in a result (optional, default to 20)
     * @param skip The number of items to skip within the results (optional, default to 0)
     * @return An array of Todo items (status code 200)
     *         or Todo list not found (status code 404)
     */
    @Operation(
        operationId = "getItemsByListId",
        summary = "Gets Todo items within the specified list",
        tags = { "Items" },
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "An array of Todo items",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TodoItem.class)) }
            ),
            @ApiResponse(responseCode = "404", description = "Todo list not found"),
        }
    )
    @RequestMapping(method = RequestMethod.GET, value = "/lists/{listId}/items", produces = { "application/json" })
    default ResponseEntity<List<TodoItem>> getItemsByListId(
        @Parameter(name = "listId", description = "The Todo list unique identifier", required = true) @PathVariable(
            "listId"
        ) String listId,
        @Parameter(name = "top", description = "The max number of items to returns in a result") @Valid @RequestParam(
            value = "top",
            required = false,
            defaultValue = "20"
        ) BigDecimal top,
        @Parameter(name = "skip", description = "The number of items to skip within the results") @Valid @RequestParam(
            value = "skip",
            required = false,
            defaultValue = "0"
        ) BigDecimal skip
    ) {
        getRequest()
            .ifPresent(request -> {
                for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString =
                            "{ \"listId\" : \"listId\", \"dueDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"completedDate\" : \"2000-01-23T04:56:07.000+00:00\" }";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * GET /lists/{listId}/items/state/{state} : Gets a list of Todo items of a specific state
     *
     * @param listId The Todo list unique identifier (required)
     * @param state The Todo item state (required)
     * @param top The max number of items to returns in a result (optional, default to 20)
     * @param skip The number of items to skip within the results (optional, default to 0)
     * @return An array of Todo items (status code 200)
     *         or Todo list or item not found (status code 404)
     */
    @Operation(
        operationId = "getItemsByListIdAndState",
        summary = "Gets a list of Todo items of a specific state",
        tags = { "Items" },
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "An array of Todo items",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TodoItem.class)) }
            ),
            @ApiResponse(responseCode = "404", description = "Todo list or item not found"),
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/lists/{listId}/items/state/{state}",
        produces = { "application/json" }
    )
    default ResponseEntity<List<TodoItem>> getItemsByListIdAndState(
        @Parameter(name = "listId", description = "The Todo list unique identifier", required = true) @PathVariable(
            "listId"
        ) String listId,
        @Parameter(name = "state", description = "The Todo item state", required = true) @PathVariable(
            "state"
        ) TodoState state,
        @Parameter(name = "top", description = "The max number of items to returns in a result") @Valid @RequestParam(
            value = "top",
            required = false,
            defaultValue = "20"
        ) BigDecimal top,
        @Parameter(name = "skip", description = "The number of items to skip within the results") @Valid @RequestParam(
            value = "skip",
            required = false,
            defaultValue = "0"
        ) BigDecimal skip
    ) {
        getRequest()
            .ifPresent(request -> {
                for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString =
                            "{ \"listId\" : \"listId\", \"dueDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"completedDate\" : \"2000-01-23T04:56:07.000+00:00\" }";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * PUT /lists/{listId}/items/{itemId} : Updates a Todo item by unique identifier
     *
     * @param listId The Todo list unique identifier (required)
     * @param itemId The Todo item unique identifier (required)
     * @param todoItem The Todo Item (optional)
     * @return A Todo item result (status code 200)
     *         or Todo item is invalid (status code 400)
     *         or Todo list or item not found (status code 404)
     */
    @Operation(
        operationId = "updateItemById",
        summary = "Updates a Todo item by unique identifier",
        tags = { "Items" },
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "A Todo item result",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TodoItem.class)) }
            ),
            @ApiResponse(responseCode = "400", description = "Todo item is invalid"),
            @ApiResponse(responseCode = "404", description = "Todo list or item not found"),
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/lists/{listId}/items/{itemId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<TodoItem> updateItemById(
        @Parameter(name = "listId", description = "The Todo list unique identifier", required = true) @PathVariable(
            "listId"
        ) String listId,
        @Parameter(name = "itemId", description = "The Todo item unique identifier", required = true) @PathVariable(
            "itemId"
        ) String itemId,
        @Parameter(name = "TodoItem", description = "The Todo Item") @Valid @RequestBody(required = false) TodoItem todoItem
    ) {
        getRequest()
            .ifPresent(request -> {
                for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString =
                            "{ \"listId\" : \"listId\", \"dueDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"completedDate\" : \"2000-01-23T04:56:07.000+00:00\" }";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * PUT /lists/{listId}/items/state/{state} : Changes the state of the specified list items
     *
     * @param listId The Todo list unique identifier (required)
     * @param state The Todo item state (required)
     * @param requestBody unique identifiers of the Todo items to update (optional)
     * @return Todo items updated (status code 204)
     *         or Update request is invalid (status code 400)
     */
    @Operation(
        operationId = "updateItemsStateByListId",
        summary = "Changes the state of the specified list items",
        tags = { "Items" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Todo items updated"),
            @ApiResponse(responseCode = "400", description = "Update request is invalid"),
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/lists/{listId}/items/state/{state}",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> updateItemsStateByListId(
        @Parameter(name = "listId", description = "The Todo list unique identifier", required = true) @PathVariable(
            "listId"
        ) String listId,
        @Parameter(name = "state", description = "The Todo item state", required = true) @PathVariable(
            "state"
        ) TodoState state,
        @Parameter(
            name = "request_body",
            description = "unique identifiers of the Todo items to update"
        ) @Valid @RequestBody(required = false) List<String> requestBody
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
