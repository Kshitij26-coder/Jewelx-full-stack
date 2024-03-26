package in.jewelx.jewelxbackend.mapper;

import java.math.BigDecimal;
import in.jewelx.jewelxbackend.dto.accounting.AccountingDto;
import in.jewelx.jewelxbackend.dto.subsidiary_maintenance.SubsidiaryMaintenanceDto;
import in.jewelx.jewelxbackend.dto.subsidiary_maintenance.SubsidiaryMaintenanceRespDto;
import in.jewelx.jewelxbackend.entity.SubsidiaryMaintenance;

public class SubsidiaryMaintenanceMapper {

	public static AccountingDto subsidiaryMaintenanceDtoToAccountingDto(SubsidiaryMaintenanceDto dto) {
		AccountingDto accountingDto = new AccountingDto();
		accountingDto.setTransactionType(dto.getTransactionType());
		accountingDto.setDescription(dto.getMaintenanceDescription());
		accountingDto.setTransactionMode(dto.getTransactionMode());
		accountingDto.setChequeNo(dto.getChequeNo());
		accountingDto.setChequeAmount(dto.getChequeAmount().multiply(new BigDecimal("-1")));
		accountingDto.setCashAmount(dto.getCashAmount().multiply(new BigDecimal("-1")));
		accountingDto.setNetBankingUTR(dto.getNetBankingUTR());
		accountingDto.setNetBankingAmount(dto.getNetBankingAmount().multiply(new BigDecimal("-1")));
		accountingDto.setUserId(dto.getUserId());
		accountingDto.setBrandId(dto.getBrandId());
		accountingDto.setSubsidiaryId(dto.getSubsidiaryId());
		return accountingDto;
	}

	public static SubsidiaryMaintenanceRespDto entityToDto(SubsidiaryMaintenance entity) {
		SubsidiaryMaintenanceRespDto dto = new SubsidiaryMaintenanceRespDto(entity.getIdxId(),
				entity.getMaintenanceId(), entity.getMaintenanceDescription(),AccountingMapper.entityToShortDto(entity.getAccounting()),
				UserMapper.UserEntityToUserShortDetailsDto(entity.getCreatedBy()), entity.getBrand().getBrandId(),SubsidiaryMapper.mapToSubsidiaryShortDetailsDto(entity.getSubsidiary()));
		return dto;
	}
	
	
}
