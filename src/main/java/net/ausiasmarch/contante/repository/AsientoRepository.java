package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.contante.entity.AsientoEntity;
import net.ausiasmarch.contante.entity.InventariableEntity;

public interface AsientoRepository extends JpaRepository<AsientoEntity, Long> {

  Page<AsientoEntity> findByDescripcionContainingOrComentariosContaining(
      String filter2, String filter3, Pageable oPageable);

  @Query(value = "SELECT * FROM asiento WHERE (descripcion LIKE %:strDescripcion% OR comentarios LIKE %:strComentarios%) AND id_usuario=:id_usuario", nativeQuery = true)
  Page<AsientoEntity> findByUsuarioIdAndDescripcionContainingOrComentariosContaining(String strDescripcion,
      String strComentarios, Long id_usuario, Pageable oPageable);

  Page<AsientoEntity> findByUsuarioId(Long id_usuario, Pageable oPageable);
  
  @Query(value = "SELECT * FROM periodo WHERE (descripcion LIKE %:strDescripcion% OR comentarios LIKE %:strComentarios%) AND id_periodo=:id_periodo", nativeQuery = true)
  Page<AsientoEntity> findByPeriodoIdAndDescripcionContainingOrComentariosContaining(String strDescripcion,
      String strComentarios, Long id_periodo, Pageable oPageable);

  Page<AsientoEntity> findByPeriodoId(Long id_periodo, Pageable oPageable);

  @Query(value = "SELECT * FROM asiento WHERE (descripcion LIKE %:strDescripcion% OR comentarios LIKE %:strComentarios%) AND id_tipoasiento=:id_tipoasiento", nativeQuery = true)
  Page<AsientoEntity> findByTipoasientoIdAndDescripcionContainingOrComentariosContaining(String strDescripcion,
      String strComentarios, Long id_tipoasiento, Pageable oPageable);

  Page<AsientoEntity> findByTipoasientoId(Long id_tipoasiento, Pageable oPageable);

  //Filtrar por asientos inventariables=1
  @Query(value = "SELECT COUNT(*) as Inventariable FROM asiento WHERE inventariable=1", nativeQuery = true)
  InventariableEntity countAsientosInventariables();
  
}
