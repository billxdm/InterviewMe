package main.resource;

import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by dxiong15 on 7/13/17.
 */
public class FileImportResource {


  public FileImportResource() {

  }


  @POST
  @Path("/v1/import/csv")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @ApiOperation()
  public Response

  /*
  @POST
  @Path("/v1/import/csv")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @ApiOperation(value = "Import taxonomy data as csv", notes = "Submit a request with taxonomy data as csv attachment")
  @ApiResponses({@ApiResponse(code = 200, message = "Taxonomy file write success, returns fileId"),
      @ApiResponse(code = 403, message = "Taxonomy edit or admin access not found (access forbidden)"),
      @ApiResponse(code = 509, message = "Taxonomy file write failed")})
  public Response uploadCsvAttachment(
      @FormDataParam("file") InputStream inputStream,
      @FormDataParam("file") FormDataContentDisposition contentDisposition,
      @NotNull @ApiParam(value = "Import operation: create, update", required = true) @QueryParam("operation")
          ImportOperation operation,
      @NotNull @ApiParam(value = "Import segment type: atomic, atomic_execution_platforms, compound, compound_execution_platforms", required = true) @QueryParam("segmentType")
          ImportSegmentType segmentType,
      @NotNull @DefaultValue("1") @ApiParam(value = "Taxonomy ID", required = true) @QueryParam("taxonomyId") int taxonomyId,
      @Auth @Valid OCUserInfo info) throws ServiceException {

    try {
      AdvertiserScope.checkUserEntitlements(UserEntitlements.LIMITED_WRITE,
          AdvertiserScope.findUserEntitlements(info.getEntitlements()));
    } catch (com.aol.dmp.taxonomy.exception.ServiceException e) {
      return Response.status(403)
                     .type(MediaType.TEXT_PLAIN)
                     .entity("Taxonomy edit or admin access not found, " + e.getMessage())
                     .build();
    }
    TaxonomyDataImportService service = new TaxonomyDataImportService();
    ImportOptions importOptions = new ImportOptions();

    if (contentDisposition == null) {
      throw new ServiceException("Failed to upload csv",
          "Content disposition is not set, make sure your HTML input element name attribute is to set to \"file\".");
    }

    if (!contentDisposition.getFileName().endsWith(".csv")) {
      throw new ServiceException("Failed to upload csv",
          "File extension must be .csv");
    }

    importOptions.setFileName(contentDisposition.getFileName());
    importOptions.setSegmentType(segmentType);
    importOptions.setBulkImportType(operation);
    importOptions.setUser(new ImportOptions.UserInfo());
    importOptions.getUser().setUsername(info.getUsername());
    importOptions.getUser().setFirstName(info.getFirstName());
    importOptions.getUser().setLastName(info.getLastName());
    importOptions.getUser().setEmail(info.getEmail());
    importOptions.setTaxonomyId(taxonomyId);
    String fileId = service.writeToJsonFile(inputStream, importOptions, prop);
    if (fileId != null) {
      return Response.status(200).type(MediaType.TEXT_PLAIN).entity(fileId).build();
    }
    return Response.status(509).type(MediaType.TEXT_PLAIN).entity("File write failure").build();

  }
   */
}
