package cn.hutool.poi.excel.test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import cn.hutool.poi.excel.ExcelBase;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class MyExcelBaseTest {
    private ExcelBase excel;
    private Sheet sheet;
    private Workbook workbook;

    @Before
    public void setup() {
        sheet = mock(Sheet.class);
        workbook = mock(Workbook.class);
        when(sheet.getWorkbook()).thenReturn(workbook);
        excel = new ExcelBase(sheet);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSheetCount() {
        when(workbook.getNumberOfSheets()).thenReturn(3);
        assertThat(excel.getSheetCount()).isEqualTo(3);
        verify(workbook, times(1)).getNumberOfSheets();
    }

    @Test
    public void testGetSheetNames() {
        when(workbook.getNumberOfSheets()).thenReturn(3);
        when(workbook.getSheetAt(anyInt())).thenReturn(sheet);
        when(sheet.getSheetName()).thenReturn("Name");
        List<String> l = Arrays.asList("Name", "Name", "Name");
        assertThat(excel.getSheetNames()).isEqualTo(l);
        verify(workbook, times(3)).getSheetAt(anyInt());
    }

    @Test
    public void testGetRowCount(){
        when(sheet.getLastRowNum()).thenReturn(11);
        assertThat(excel.getRowCount()).isEqualTo(12);
        verify(sheet, times(1)).getLastRowNum();
    }

    @Test
    public void testGetPhysicalRowCount(){
        when(sheet.getPhysicalNumberOfRows()).thenReturn(10);
        assertThat(excel.getPhysicalRowCount()).isEqualTo(10);
        verify(sheet, times(1)).getPhysicalNumberOfRows();
    }

}
