package in.jewelx.jewelxbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jewelx.jewelxbackend.dto.itemsale.ItemSaleDto;
import in.jewelx.jewelxbackend.dto.itemsale.ItemSaleResponse;
import in.jewelx.jewelxbackend.entity.ArticleStockEntity;
import in.jewelx.jewelxbackend.entity.ItemSaleEntity;
import in.jewelx.jewelxbackend.entity.SaleEntity;
import in.jewelx.jewelxbackend.entity.UserEntity;
import in.jewelx.jewelxbackend.mapper.ItemSaleMapper;
import in.jewelx.jewelxbackend.repository.ItemSaleRepository;
import in.jewelx.jewelxbackend.service.IItemSaleService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemSaleService implements IItemSaleService {

	@Autowired
	ItemSaleRepository itemSaleRepository;

	@Override
	public String addItemSale(ItemSaleDto dto) {
		ItemSaleEntity itemSaleEntity = new ItemSaleEntity(new ArticleStockEntity(dto.getTagId()), dto.getItemAmount(),
				dto.getMetalRate(), dto.getArtifactAmount(), dto.getPayableAmount(), dto.getMakingCharges(),
				new SaleEntity(dto.getSaleId()));
		itemSaleEntity.setCreatedBy(new UserEntity(dto.getUserId()));
		itemSaleEntity.setUpdatedBy(new UserEntity(dto.getUserId()));
		itemSaleRepository.save(itemSaleEntity);
		return "Item Sale Successfully !!!";
	}

	@Override
	public List<ItemSaleResponse> getItemSaleBySaleId(Long saleId) {
		List<ItemSaleEntity> allItemSales = itemSaleRepository.findBySale_IdxId(saleId);
		return allItemSales.stream().map(ItemSaleMapper::dtoToEntity).collect(Collectors.toList());
	}
}
