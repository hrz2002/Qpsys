package business.entity.member.excel;

import java.io.*;
import java.util.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;

/**
 * <p>
 * 既存のブックにシートを出力します。
 * </p>
 *
 * @author $Author:  $
 * @version $Revision: 5618 $ - $Date: 2008-06-27 09:48:49 +0800 $
 */
public class MemberExcelWriter {

    public static void main(final String[] args) throws IOException {


        final HSSFWorkbook wb = new HSSFWorkbook();
        final HSSFSheet sheet = wb.createSheet("原紙");
        final HSSFRow row = sheet.createRow(1);
        final HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.ORANGE.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);



        createCell(wb, row, 0, cellStyle);

        createCell(wb, row, 1, cellStyle);
        createCell(wb, row, 2, cellStyle);
        createCell(wb, row, 3, cellStyle);
        createCell(wb, row, 4, cellStyle);
        createCell(wb, row, 5, cellStyle);
        createCell(wb, row, 6, cellStyle);
        sheet.addMergedRegion(new CellRangeAddress(2, 3, 1, 6));

        // Write the output to a file
        final Date time = new Date();
        final FileOutputStream fileOut = new FileOutputStream("c://workbook" + time.getTime() + ".xls");
        wb.write(fileOut);
        System.out.print("excel is out");
        fileOut.close();
    }

    /**
    * Creates a cell and aligns it a certain way.
    **
    @param wb the workbook
    * @param row the row to create the cell in
    * @param column the column number to create the cell in
    * @param align the alignment for the cell.
    */
    private static void createCell(final HSSFWorkbook wb, final HSSFRow row, final int column, final HSSFCellStyle cellStylellStyle) {
        final HSSFCell cell = row.createCell(column);
        final HSSFRichTextString value = new HSSFRichTextString("HSSFRichTextString");
        cell.setCellStyle(cellStylellStyle);
        cell.setCellValue(value);
    }

}
