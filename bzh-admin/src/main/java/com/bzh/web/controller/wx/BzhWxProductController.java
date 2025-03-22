package com.bzh.web.controller.wx;

import com.bzh.business.domain.BzhProduct;
import com.bzh.business.domain.BzhStoreReservation;
import com.bzh.business.service.IBzhProductService;
import com.bzh.business.service.IBzhStoreReservationService;
import com.bzh.business.service.IBzhStoreService;
import com.bzh.common.constant.Constants;
import com.bzh.common.core.controller.BaseController;
import com.bzh.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


/**
 * 小程序商品Controller
 *
 * @author bzh
 * @date 2025-01-06
 */
@RestController
@RequestMapping("/wx/product")
public class BzhWxProductController extends BaseController
{
    @Autowired
    private IBzhProductService bzhProductService;

    /**
     * 根据产品类目id查询商品列表
     */
    @GetMapping("/getProductListByCategoryId")
    public AjaxResult getProductListByCategoryId(@RequestParam(value = "categoryId") Long categoryId,
                                                 @RequestParam(value = "sortKey",required = false) String sortKey,
                                                 @RequestParam(value = "priceSort",required = false) String priceSort)
    {
        BzhProduct bzhProduct = new BzhProduct();
        bzhProduct.setSortColumn(sortKey);
        bzhProduct.setPriceSort(priceSort);
        bzhProduct.setCategoryId(categoryId);
        bzhProduct.setStatus(Constants.STATUS_YES);
        return success(bzhProductService.selectList(bzhProduct));
    }

    /**
     * 根据门店id查询推荐商品列表
     */
    @GetMapping("/getRecommendProductListByStoreId")
    public AjaxResult getRecommendProductListByStoreId(@RequestParam("storeId") Long storeId)
    {
        BzhProduct bzhProduct = new BzhProduct();
        bzhProduct.setStoreId(storeId);
        bzhProduct.setRecommend(Constants.STATUS_YES);
        bzhProduct.setStatus(Constants.STATUS_YES);
        return success(bzhProductService.selectList(bzhProduct));
    }


    /**
     * 根据门店id查询推荐商品列表
     */
    @GetMapping("/getProductListByStoreIdAndProductName")
    public AjaxResult getProductListByStoreIdAndProductName(@RequestParam("storeId") Long storeId,
                                                            @RequestParam("productName") String productName)
    {
        BzhProduct bzhProduct = new BzhProduct();
        bzhProduct.setStoreId(storeId);
        bzhProduct.setProductName(productName);
        bzhProduct.setStatus(Constants.STATUS_YES);
        return success(bzhProductService.selectList(bzhProduct));
    }

    /**
     * 根据商品id查询商品
     */
    @GetMapping("/getProductDetailByProductId")
    public AjaxResult getProductDetailByProductId(@RequestParam("productId") Long productId)
    {
        return success(bzhProductService.getProductDetailByProductId(productId));
    }

    /**
     * 根据手机号获取预约商品
     */
    @GetMapping("/getProductListByPhoneNumber")
    public AjaxResult getProductListByPhoneNumber(@RequestParam(value = "phoneNumber") String phoneNumber)
    {
        return success(bzhProductService.getProductListByPhoneNumber(phoneNumber));
    }

}
