package com.dayuan.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayuan.bean.CartInfo;
import com.dayuan.bean.OrderInfo;
import com.dayuan.service.CartService;
import com.dayuan.service.OrderService;

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

/**
 * Servlet implementation class JslExcel
 */
@WebServlet("/JslExcel")
public class JslExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JslExcel() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource
    public CartService cartService;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  OutputStream output=response.getOutputStream();  
		  
		  response.reset();  
		  
		  response.setHeader("Content-disposition","attachment;           filename=temp.xls");  
		  
		  response.setContentType("application/msexcel");  
		  
		  //创建可写入的Excel工作薄，且内容将写入到输出流，并通过输出流输出给客户端浏览  
		  
		  WritableWorkbook wk=Workbook.createWorkbook(output);  
		  
		  
		///创建可写入的Excel工作表  
		  
		    WritableSheet sheet=wk.createSheet("成绩表", 0);  
		  
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
			  
			Label lab_11=new Label(1,1,"cart_id",cloumnTitleFormat);  
			  
			Label lab_21=new Label(2,1,"goods_id",cloumnTitleFormat);  
			  
			Label lab_31=new Label(3,1,"goods_name",cloumnTitleFormat);  
			  
			Label lab_41=new Label(4,1,"picture_url",cloumnTitleFormat);
			Label lab_51=new Label(5,1,"buy_number",cloumnTitleFormat);
			Label lab_61=new Label(6,1,"goods_original_price",cloumnTitleFormat);
			Label lab_71=new Label(7,1,"goods_promotion_price",cloumnTitleFormat);
			Label lab_81=new Label(8,1,"create_time",cloumnTitleFormat);
			
			  
			  sheet.addCell(lab_01);  
			  
			  sheet.addCell(lab_11);  
			  
			  sheet.addCell(lab_21);  
			  
			  sheet.addCell(lab_31);  
			  
			  sheet.addCell(lab_41); 
	
			  
			  sheet.addCell(lab_51);  
			  
			  sheet.addCell(lab_61);  
			  
			  sheet.addCell(lab_71);  
			  
			  sheet.addCell(lab_81);
			  
			  List<CartInfo> cartInfos=cartService.selectCartInfoS();
			  
			  
			  sheet.addCell(new Label(0,2,"李明"));  
			  
			  sheet.addCell(new Label(1,2,"As178"));  
			  
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
		  
		  
		  
//		sheet.addCell(numlab_22);  
//		  
//		sheet.addCell(new Number(3,2,87,new WritableCellFormat(new NumberFormat("#.##") )));  		  
		//定义日期格式  	  
		try {
			wk.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		File file=new File("D://temp.xls");  
		WritableWorkbook wwb = Workbook.createWorkbook(file);  
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
