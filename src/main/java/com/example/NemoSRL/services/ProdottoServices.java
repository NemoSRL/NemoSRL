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
import java.util.List;

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
}
