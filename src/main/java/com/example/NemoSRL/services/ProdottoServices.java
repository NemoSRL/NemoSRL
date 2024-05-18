package com.example.NemoSRL.services;

import com.example.NemoSRL.model.Prodotto;
import com.example.NemoSRL.repository.ProdottoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdottoServices {
    @Autowired
    private ProdottoRepository prodottoRepository;
    //Transactional(readOnly=true)
    public List<Prodotto> showAllProducts(int pNum, int pSize, String sortBy){
        Pageable paging = PageRequest.of(pNum, pSize, Sort.by(sortBy));
        Page<Prodotto> pagedResult = prodottoRepository.findAll(paging);
        if ( pagedResult.hasContent() ) {
            return pagedResult.getContent();
        }
        else {
            return new ArrayList<>();
        }
    }
    public List<Integer> showAllProductsIds(){
        List<Integer> prodottiId = prodottoRepository.findAll().stream()
                .map(Prodotto::getId)
                .collect(Collectors.toList());
        return prodottiId;
    }
    public List<Prodotto> showAllProducts(){
        return prodottoRepository.findAll();
    }
    public Prodotto addProdotto(Prodotto prodotto) throws Exception{
        Prodotto result= prodottoRepository.save(prodotto);
        return result;
    }
    public void eliminaProdottoPerId(int prodotto){
         prodottoRepository.deleteById(prodotto);
    }
    public List<Prodotto>showAllAvanzato(Integer id,String qualita,String nome){
        return prodottoRepository.richercaAvanzata(nome,qualita,id);
    }
    public Prodotto updateProdotto(Prodotto prodotto){
        return prodottoRepository.save(prodotto);
    }
}
