package com.Car4All.Proyecto.controller;

import com.Car4All.Proyecto.entity.Categoria;
import com.Car4All.Proyecto.exception.ResourceNotFoundException;
import com.Car4All.Proyecto.service.CategoriaService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @Autowired
    private CategoriaService categoriaService= new CategoriaService()


    @GetMapping("/listar")
    public List<Categoria> listarCategorias() {
        List<Categoria> categorias = categoriaService.mostrarTodos();
        return categorias;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarUnaCategoria(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarCategoria(@RequestBody Categoria categoria) {
        String base64Image = (categoria.getImagen() != null) ? categoria.getImagen() : "";
        ObjectMetadata objectMetadata = new ObjectMetadata();

        try {
            byte[] binaryData = Base64.getDecoder().decode(base64Image);


            String key = categoria.getTitulo() + "_" + UUID.randomUUID().toString() + ".jpg";

            objectMetadata.setContentLength(binaryData.length);
            s3.putObject("onlybooksbucket", key, new ByteArrayInputStream(binaryData), objectMetadata);
            categoria.setImagen("https://onlybooksbucket.s3.amazonaws.com/" + key);
        } catch (IllegalArgumentException | AmazonServiceException e) {
            System.err.println("Error al procesar la imagen " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar la categoría.");
        }
        categoriaService.guardar(categoria);
        return ResponseEntity.status(HttpStatus.OK).body(categoria.getId());
    }

    // En la url "/categoria/modificar" actualizamos un user ya existente
    @PutMapping("/modificar")
    public ResponseEntity<?> actualizarUnaCategoria(@RequestBody Categoria categoria) {
        categoriaService.modificar(categoria);
        return ResponseEntity.ok().body("Se modificó la categoría.");
    }

    // En la url "/categoria/eliminar/{id}" utilizamos el metodo DELETE para eliminar un user segun su ID, si no existe lanzo ResourceNotFoundException
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<?> response = null;
        categoriaService.eliminar(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Categoría eliminada.");
        return response;
    }
}