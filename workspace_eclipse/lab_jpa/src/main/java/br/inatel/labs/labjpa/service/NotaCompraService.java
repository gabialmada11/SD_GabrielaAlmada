package br.inatel.labs.labjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class NotaCompraService {
	
	@PersistenceContext
	private EntityManager em;
	
	//Nota Compra
	public NotaCompra salvarNotaCompra(NotaCompra nota) {
		return em.merge(nota);
	}
	
	public NotaCompra buscarNotaCompraPeloId(Long id) {
		return em.find(NotaCompra.class, id);
	}
	
	public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
		NotaCompra notaCompra = em.find(NotaCompra.class, id);
		notaCompra.getListaNotaCompraItem().size();
		return notaCompra;
	}
	
	public List<NotaCompra> listarNotaCompra(){
		return em.createQuery("select n from NotaCompra n", NotaCompra.class)
				.getResultList();
	}
	
	//Nota Compra Item
	public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
		return em.merge(item);
	}
	
	public NotaCompraItem buscarNotaCompraItemPeloId(Long id) {
		return em.find(NotaCompraItem.class, id);
	}
	
	public List<NotaCompraItem> listarNotaCompraItem(){
		return em.createQuery("select i from NotaCompraItem i", NotaCompraItem.class)
				.getResultList();
	}

}
