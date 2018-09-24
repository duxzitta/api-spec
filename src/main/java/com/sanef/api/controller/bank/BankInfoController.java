package com.sanef.api.controller.bank;

import java.util.List;

import com.sanef.api.vo.GenericFailureResponse;
import com.sanef.api.vo.GenericResponse;
import com.sanef.api.vo.GenericSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanef.api.controller.BaseApiController;
import com.sanef.api.dto.BankBranchInfoDto;
import com.sanef.api.service.BankService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Api(value = "/branch", description = "Bank/Branch related operations", consumes = "application/json", tags = {"Branch"})
@RestController
@Slf4j
@RequestMapping(path="/branch")
public class BankInfoController extends BaseApiController {

	@Autowired
	private BankService bankService;

    @ApiOperation(value = "Get all Branches of a Bank",
            response = BankBranchInfoDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Branch not found")})
	@GetMapping(path="/branche")
	public GenericResponse<List<BankBranchInfoDto>> getBankBranchInfos() {
		List<BankBranchInfoDto> bankInfo=bankService.getBranchInfo();
		if(bankInfo==null) {
			return new GenericFailureResponse<>("Error processing request");
		}
		return new GenericSuccessResponse<List<BankBranchInfoDto>>("Request processed ok",bankInfo);
	}
	
   
    @ApiOperation(value = "Gets get a specific branch by its branch ID",
            response = BankBranchInfoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Branch not found"),
            @ApiResponse(code = 400, message = "Invalid Branch ID specified"),
            @ApiResponse(code = 200, response = BankBranchInfoDto.class, message = "Branch Information")})
	@GetMapping(path="/branche/{branchId}")
	public GenericResponse<BankBranchInfoDto> getBranchById(@PathVariable @ApiParam(value = "The Branch ID", required = true) String branchId) {
		List<BankBranchInfoDto> bankInfo=bankService.getBranchInfo();
		if(bankInfo==null) {
			return new GenericFailureResponse<>("Error processing request");
		}
		return new GenericSuccessResponse<BankBranchInfoDto>("Request processed ok",bankInfo.get(0));
	}
	

	
}