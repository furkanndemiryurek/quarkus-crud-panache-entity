package resources;

import entity.Product;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.ProductService;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    public Response findAll(){
        List<Product> products = productService.findAll();
        return Response.ok(products).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        Product product = productService.findById(id);
        return Response.ok(product).build();
    }

    @POST
    public Response add(Product product){
        Product addedProduct = productService.add(product);
        return Response.ok(addedProduct).status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") Long id){
        String isDeleted = productService.deleteById(id);
        return Response.ok(isDeleted).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Product product){
        Product productToUpdate =  productService.update(id, product);
        return Response.ok(productToUpdate).status(Response.Status.ACCEPTED).build();
    }
}
