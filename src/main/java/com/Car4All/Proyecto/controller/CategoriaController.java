package com.Car4All.Proyecto.controller;

import com.Car4All.Proyecto.entity.Auto;
import com.Car4All.Proyecto.entity.Categoria;
import com.Car4All.Proyecto.exception.ResourceNotFoundException;
import com.Car4All.Proyecto.request.CategoriaAutoRequest;
import com.Car4All.Proyecto.request.CategoriaNombreAutoRequest;
import com.Car4All.Proyecto.service.CategoriaService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    private static final Logger logger= LogManager.getLogger(CategoriaController.class);
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> registrarCategoria(@RequestBody Categoria categoria){
        logger.info("Llego la peticion de registrar la categoria: "+categoria);
        return ResponseEntity.ok(categoriaService.guardarCategoria(categoria));
    }
    @PutMapping
    public ResponseEntity<String> actualizarCategoria(@RequestBody Categoria categoria) throws ResourceNotFoundException {
        logger.info("Llego la peticion de actualizar la categoria: "+categoria);
        Optional<Categoria> categoriaBuscado= categoriaService.buscarPorId(categoria.getId());
        if(categoriaBuscado.isPresent()){
            logger.info("Se actualizo la categoria: " + categoria);
            categoriaService.actualizarCategoria(categoria);
            return ResponseEntity.ok("Categoria: "+categoria.getNombre()+" actualizada con exito.");
        }else{
            logger.info("No se actualizo la categoria: " + categoria);
            throw new ResourceNotFoundException("No se pudo encontrar la categoria con el id: "+categoria.getId()+".");
        }
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Categoria>> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de buscar una categoria con el id: "+id);
        Optional<Categoria> categoriaBuscado= categoriaService.buscarPorId(id);
        if(categoriaBuscado.isPresent()){
            logger.info("Se encontro la categoria con el id: "+id);
            return ResponseEntity.ok(categoriaBuscado);
        }else{
            logger.info("No se encontro la categoria con el id: "+id);
            throw new ResourceNotFoundException("No se pudo encontrar la categoria con el id: "+id+".");
        }
    }
    @GetMapping("/buscar/categoriaNombre/{categoriaNombre}")
    public ResponseEntity<Optional<Categoria>> buscarPorNombreCategoria(@PathVariable String categoriaNombre) throws ResourceNotFoundException {
        logger.info("Llego la peticion de buscar una categoria con el nombre: "+categoriaNombre);
        Optional<Categoria> categoriaBuscada= categoriaService.buscarPorNombre(categoriaNombre);
        if(categoriaBuscada.isPresent()){
            logger.info("Se encontro la categoria con el nombre: "+categoriaNombre);
            return ResponseEntity.ok(categoriaBuscada);
        }else{
            logger.info("No se encontro la categoria con el nombre: "+categoriaNombre);
            throw new ResourceNotFoundException("No se pudo encontrar la categoria con el nombre: "+categoriaNombre+".");
        }
    }
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() throws ResourceNotFoundException{
        logger.info("Llego la peticion de listar todos los categorias");
        List<Categoria> listaCategorias = categoriaService.listarCategorias();
        if(listaCategorias.size() > 0){
            logger.info("Existen categorias");
            return ResponseEntity.ok(listaCategorias);
        }else{
            logger.info("No existen categorias");
            throw new ResourceNotFoundException("No hay ningun categoria presente en la base de datos.");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Llego la peticion de eliminar la categoria con el id: "+id);
        Optional<Categoria> categoriaBuscado = categoriaService.buscarPorId(id);
        if(categoriaBuscado.isPresent()){
            logger.info("Se elimino la categoria con el id: "+id);
            categoriaService.eliminarCategoria(id);
            return ResponseEntity.ok("Categoria con el id: "+ id +" eliminado con exito.");
        }else
            logger.info("No se elimino la categoria con el id: "+id);
        throw  new ResourceNotFoundException("No se encontro categoria a eliminar.");
    }
    @PostMapping("/agregar-auto")
    public ResponseEntity<String> agregarAutoACategoria(@RequestBody CategoriaAutoRequest request) {
        logger.info("Llego la peticion de agregar auto con el id: "+request.getAutoId()+" en la categoria con el id: "+request.getCategoriaId());
        Optional<Categoria> categoriaOptional = categoriaService.agregarAutoACategoria(request.getCategoriaId(), request.getAutoId());
        return categoriaOptional.map(categoria -> ResponseEntity.ok("Auto agregado a la categoría"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoría o auto no encontrado"));
    }

    @DeleteMapping("/eliminar-auto")
    public ResponseEntity<String> eliminarAutoDeCategoria(@RequestBody CategoriaAutoRequest request) {
        Optional<Categoria> categoriaOptional = categoriaService.eliminarAutoDeCategoria(request.getCategoriaId(), request.getAutoId());
        return categoriaOptional.map(categoria -> ResponseEntity.ok("Auto eliminado de la categoría"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoría o auto no encontrado"));
    }
    @PostMapping("/agregar-auto/porNombreCategoria")
    public ResponseEntity<String> agregarAutoACategoriaNombre(@RequestBody CategoriaNombreAutoRequest request) {
        logger.info("Llego la peticion de agregar auto con el id: "+request.getAutoId()+" en la categoria con el nombre: "+request.getCategoriaNombre());
        Optional<Categoria> categoriaOptional = categoriaService.agregarAutoACategoria(request.getCategoriaNombre(), request.getAutoId());
        return categoriaOptional.map(categoria -> ResponseEntity.ok("Auto agregado a la categoría"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoría o auto no encontrado"));
    }

    @DeleteMapping("/eliminar-auto/porNombreCategoria")
    public ResponseEntity<String> eliminarAutoDeCategoriaNombre(@RequestBody CategoriaNombreAutoRequest request) {
        Optional<Categoria> categoriaOptional = categoriaService.eliminarAutoDeCategoria(request.getCategoriaNombre(), request.getAutoId());
        return categoriaOptional.map(categoria -> ResponseEntity.ok("Auto eliminado de la categoría"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoría o auto no encontrado"));
    }
}