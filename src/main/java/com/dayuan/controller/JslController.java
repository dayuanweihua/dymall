package com.dayuan.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dayuan.bean.CartInfo;
import com.dayuan.constant.ConstantCode;
import com.dayuan.service.CartService;
import com.dayuan.vo.ResultVo;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

@Controller
@RequestMapping("/excel")
public class JslController {
	private static Logger logger = LoggerFactory.getLogger(UserInfoController.class);

	@Resource
	public CartService cartService;
	
	@RequestMapping(value = "/exportExcel.shtml", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResultVo getGoodsTypes(HttpServletResponse response) {
		ResultVo resultVo = null;
		try {
			OutputStream output=response.getOutputStream();  
			  
			  response.reset();  
			  
			  response.setHeader("Content-disposition","attachment;           filename=temp.xls");  
			  
			  response.setContentType("application/msexcel");  
			  
			  //创建可写入的Excel工作薄，且内容将写入到输出流，并通过输出流输出给客户端浏览  
			  
			  WritableWorkbook wk=Workbook.createWorkbook(output);  
			  
			  
			///创建可写入的Excel工作表  
			  
			    WritableSheet sheet=wk.createSheet("订单详情", 0);  
			  
			//把单元格（column, row）到单元格（column1, row1）进行合并。  
			  
			//mergeCells(column, row, column1, row1);  
			    WritableFont titleFont=new WritableFont(WritableFont.createFont("黑体"),12,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.LIGHT_BLUE);  
				  
				//创建WritableCellFormat对象，将该对象应用于单元格从而设置单元格的样式  
				  
				WritableCellFormat titleFormat=new WritableCellFormat();  
				  
				//设置字体格式  
				  
				titleFormat.setFont(titleFont);  
				
			  
			  try {
				sheet.mergeCells(0,0, 4,0);
				titleFormat.setAlignment(Alignment.CENTRE);  
				  
				//设置文本垂直居中对齐  
				  
				titleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);  
				  
				//设置背景颜色  
				  
				titleFormat.setBackground(Colour.GRAY_25);  
				  
				//设置自动换行  
				  
				titleFormat.setWrap(true);  
				  
				//添加Label对象，参数依次表示在第一列，第一行，内容，使用的格式  
				  
				Label lab_00=new Label(0,0,"订单详情表",titleFormat);  
				  
				//将定义好的Label对象添加到工作表上，这样工作表的第一列第一行的内容为‘学员考试成绩一览表’并应用了titleFormat定义的样式  
				  
				sheet.addCell(lab_00);  
				  
				WritableCellFormat cloumnTitleFormat=new WritableCellFormat();  
				  
				cloumnTitleFormat.setFont(new WritableFont(WritableFont.createFont("宋体"),10,WritableFont.BOLD,false));  
				  
				cloumnTitleFormat.setAlignment(Alignment.CENTRE);  
				  
				Label lab_01=new Label(0,1,"id",cloumnTitleFormat);  
				  
				Label lab_11=new Label(1,1,"订单号",cloumnTitleFormat);  
				  
				Label lab_21=new Label(2,1,"商品id",cloumnTitleFormat);  
				  
				Label lab_31=new Label(3,1,"商品名",cloumnTitleFormat);  
				  
				Label lab_41=new Label(4,1,"图片地址",cloumnTitleFormat);
				Label lab_51=new Label(5,1,"购买数量",cloumnTitleFormat);
				Label lab_61=new Label(6,1,"原价",cloumnTitleFormat);
				Label lab_71=new Label(7,1,"促销价",cloumnTitleFormat);
				
				
				  
				  sheet.addCell(lab_01);  
				  
				  sheet.addCell(lab_11);  
				  
				  sheet.addCell(lab_21);  
				  
				  sheet.addCell(lab_31);  
				  
				  sheet.addCell(lab_41); 
		
				  
				  sheet.addCell(lab_51);  
				  
				  sheet.addCell(lab_61);  
				  
				  sheet.addCell(lab_71);  
				  
				 
				  
				  List<CartInfo> cartInfos=cartService.selectCartInfoS();
				  for(int i=0;i<cartInfos.size();i++){
					  sheet.addCell(new Label(0,2+i,cartInfos.get(i).getId()+""));  
					  
					  sheet.addCell(new Label(1,2+i,cartInfos.get(i).getCartId()+"")); 
					  sheet.addCell(new Label(2,2+i,cartInfos.get(i).getGoodsId()+"")); 
					  sheet.addCell(new Label(3,2+i,cartInfos.get(i).getGoodsName()+"")); 
					  sheet.addCell(new Label(4,2+i,cartInfos.get(i).getPictureUrl()+"")); 
					  sheet.addCell(new Label(5,2+i,cartInfos.get(i).getBuyNumber()+"")); 
					  sheet.addCell(new Label(6,2+i,cartInfos.get(i).getGoodsOriginalPrice()+"")); 
					  sheet.addCell(new Label(7,2+i,cartInfos.get(i).getGoodsPromotionPrice()+"")); 
					   
				  }
				 
				  
				//定义数字格式  
				  
				NumberFormat nf=new NumberFormat("0.00");  
				  
				WritableCellFormat wcf=new WritableCellFormat(nf);
				  
				DateFormat df=new DateFormat("yyyy-MM-dd hh:mm:ss");  
				  
				//创建WritableCellFormat对象  
				  
				WritableCellFormat datewcf=new WritableCellFormat(df);  
				  
				//类似于Label对象，区别Label表示文本数据，DateTime表示日期型数据  
				  
				DateTime dtLab_42=new DateTime(4,2,new Date(),datewcf);  
				  
				sheet.addCell(dtLab_42);     
				  
				//将定义的工作表输出到之前指定的介质中（这里是客户端浏览器）  
				  
				wk.write();  
				  
				//操作完成时，关闭对象，释放占用的内存空间     
				
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//单元格合并方法  
			  
			//创建WritableFont 字体对象，参数依次表示黑体、字号12、粗体、非斜体、不带下划线、亮蓝色  
			  
			  
			//设置文本水平居中对齐  
			  
		 
			  
			//类似于Label对象，区别Label表示文本数据，Number表示数值型数据  
			  
			  
			  
//			sheet.addCell(numlab_22);  
//			  
//			sheet.addCell(new Number(3,2,87,new WritableCellFormat(new NumberFormat("#.##") )));  		  
			//定义日期格式  	  
			try {
				wk.close();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			File file=new File("D://temp.xls");  
			WritableWorkbook wwb = Workbook.createWorkbook(file);
			return resultVo;
		} catch (Exception e) {
			resultVo = new ResultVo(ConstantCode.FAIL.getCode(), ConstantCode.FAIL.getMsg());
			logger.error("前端获取商品类目失败" + e.getMessage());
			return resultVo;
		}
	}
}
