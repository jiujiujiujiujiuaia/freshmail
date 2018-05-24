package mapper;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;

import entity.Cart;
import entity.Goods;
import entity.UserGoods;
@Repository
public interface IGoodsMapper {
	@Select("select * from goods where type=#{type} order by idd desc limit 4")
	public List<Goods> getGoods(String type);
	
	@Select("select * from goods where idd=#{idd}")
	public Goods getGoodsDetail(int idd);
	
	@Insert("insert into dingdan(uid,gid,number,xiadan_time,dingdanhao,total) values(#{u},#{g},#{n},#{d},#{di},#{t})")
	public boolean addDingdan(@Param("u") int uid, @Param("g") int gid, @Param("n") int number, @Param("d") Timestamp datetime, @Param("di") int dingdanhao, @Param("t") double total);
	
	@Update("update dingdan set state=#{s},fukuan_time=#{f} where id=#{id}" )
	public int updateDingdan(@Param("s") String state, @Param("f") Timestamp datetime, @Param("id") int id);
	
	@Select("select  id from dingdan where  uid=#{u} and gid=#{g} order by id desc limit 1")
	public int getDingdanid(@Param("u") int uid, @Param("g") int gid);
	
	@Insert("insert into cart(uid,gid,picture,price,goodsname,number,total) values(#{uid},#{gid},#{picture},#{price},#{goodsname},#{number},#{total})")
	public boolean addCart(Cart cart);
	
	@Select("select COALESCE(SUM(number),0) from cart where uid=#{u} and state=#{s}")
	public int getNumber(@Param("u") int uid, @Param("s") int state);
	
	@Select("select COALESCE(SUM(total),0) from cart where uid=#{u} and state=#{s}")
	public double getTotal(@Param("u") int uid, @Param("s") int state);
	
	@Update("update dingdan set state=#{s},fukuan_time=#{f} where dingdanhao=#{id}" )
	public int updateDingdans(@Param("s") String state, @Param("f") Timestamp datetime, @Param("id") int id);
}
