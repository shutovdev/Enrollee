package viti.kaf22.xls;

import viti.kaf22.entities.Abiturient;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import viti.kaf22.entities.NomerTelefonu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by korch on 12.05.17
 */
public class XLSController<T> {
    private Workbook book;// = new HSSFWorkbook();
    private Sheet sheet;// = book.createSheet("Test");

    public XLSController(String sheetName){
        book = new HSSFWorkbook();
        sheet = book.createSheet(sheetName);
    }

    /*
    *******THIS METHOD DON`T USE (DEVELOPER VERSION)
     */
    @SuppressWarnings("unused")
	private void createHeaderRow(T object){
        Row headerRow = sheet.createRow(0);
        Class<? extends Object> obj = object.getClass();
        Field [] fields = obj.getDeclaredFields();
        Cell [] cells = new Cell[fields.length];

        for (int i = 0;  i < cells.length; i++){
            cells[i] = headerRow.createCell(i);
            cells[i].setCellValue(fields[i].getName());
        }
    }


    public void saveToSheet(Abiturient abiturient, int rowNumber){

        Row row = sheet.createRow(rowNumber);
        CellStyle dateCell = book.createCellStyle();

        DataFormat formatter = book.createDataFormat();
        dateCell.setDataFormat(formatter.getFormat("dd.mm.yyyy"));

        Cell osSpIDCell = row.createCell(0);
        Cell socStatusCell = row.createCell(1);
        Cell prizvCell = row.createCell(2);
        Cell imyaCell = row.createCell(3);
        Cell imPoBatkoviCell = row.createCell(4);
        Cell DNCell = row.createCell(5);
        Cell nomTelCell  = row.createCell(6);
        Cell seriaNomCell = row.createCell(7);
        Cell bal12Cell = row.createCell(8);
        Cell bal200Cell = row.createCell(9);
        Cell dataVidachiCell = row.createCell(10);
        Cell chasReestrCell = row.createCell(11);

        osSpIDCell.setCellValue(abiturient.getSprava());
        socStatusCell.setCellValue(abiturient.getStatus().getName());
        prizvCell.setCellValue(abiturient.getPrizvishche().getName());
        imyaCell.setCellValue(abiturient.getImya().getName());
        imPoBatkoviCell.setCellValue(abiturient.getImyaPoBatkovi().getName());

        @SuppressWarnings("unchecked")
		List<NomerTelefonu> phones  = (List<NomerTelefonu>) abiturient.getNomerTelefonus();
        for (NomerTelefonu phone : phones){
            nomTelCell.setCellValue(phone.getNomer());
        }
//        nomTelCell.setCellValue(abiturient.getNomerTelefonus().get(0).getNomer());

        DNCell.setCellStyle(dateCell);
        DNCell.setCellValue(abiturient.getBirth());

//        if (abiturient.getAtestat().size() > 0) {
            seriaNomCell.setCellValue(abiturient.getAtestat().getNomerSeria());
            bal12Cell.setCellValue(abiturient.getAtestat().getNomerSeria());
            bal200Cell.setCellValue(abiturient.getAtestat().getNomerSeria());
            dataVidachiCell.setCellStyle(dateCell);
            dataVidachiCell.setCellValue(abiturient.getAtestat().getNomerSeria());
//        }




        dateCell.setDataFormat(formatter.getFormat("HH.mm dd.MM.yyyy"));
        chasReestrCell.setCellStyle(dateCell);
        chasReestrCell.setCellValue(abiturient.getChasReestr());

    }

    public void saveAllToSheet(List<Abiturient> abiturients){
        for (int i = 0; i < abiturients.size(); i++){
            saveToSheet(abiturients.get(i), i);
        }
        saveBook(book);
    }

    private static void saveBook(Workbook book){
        try {
            book.write(new FileOutputStream("/media/korch/Space/Develop/Additional/wildfly11/welcome-content/app_storage/reports/primary.xls"));
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
