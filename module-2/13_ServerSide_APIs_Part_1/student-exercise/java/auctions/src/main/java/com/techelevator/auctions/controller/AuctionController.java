package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping outside the class makes the path specified the default path
//@RequestMapping("/auctions")	//Every method in this file handles "/auctions"
								// DO NOT CODE "/auctions" in the path= of @RequestMapping
								// YOU MUST CODE anything you expect after /auctions in the path

public class AuctionController {

    private AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }

    @RequestMapping(path = "/auctions/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
    	System.out.println("Called with path /Auctions" + id);
    	return dao.get(id);
    }
    @RequestMapping(path= "/auctions", method=RequestMethod.POST)
    public Auction createAnAuction(@RequestBody Auction auction) {
    	System.out.println("Called with the path /auctions");
    	return dao.create(auction);
    }
    
    
    // handle path "/auctions" for an HTTP GET
    // handle path "/auctions?title_like=value" for an HTTP GET
    
    @RequestMapping(path= "/auctions", method=RequestMethod.GET)
    public List<Auction> list(@RequestParam (defaultValue = "") String title_like, 
    						  @RequestParam (defaultValue = "0") double currentBid_lte) {
    	if (!title_like.equals("") && (currentBid_lte >0)) {
    		return dao.searchByTitleAndPrice(title_like, currentBid_lte);
    	}
    	else if (!title_like.equals("")) {
    		return dao.searchByTitle(title_like);
    	}
    	else if (currentBid_lte > 0) {
    		return dao.searchByPrice(currentBid_lte);
    	}
    	else return dao.list();
    }
}