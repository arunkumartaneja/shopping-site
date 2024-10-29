import Image from "next/image";
import Link from "next/link";
// import DOMPurify from "isomorphic-dompurify";
// import Pagination from "./Pagination";

const PRODUCT_PER_PAGE = 8;

const ProductList = async () => {
    // const wixClient = await wixClientServer();

    // const productQuery = wixClient.products
    //     .queryProducts()
    //     .startsWith("name", searchParams?.name || "")
    //     .eq("collectionIds", categoryId)
    //     .hasSome(
    //         "productType",
    //         searchParams?.type ? [searchParams.type] : ["physical", "digital"]
    //     )
    //     .gt("priceData.price", searchParams?.min || 0)
    //     .lt("priceData.price", searchParams?.max || 999999)
    //     .limit(limit || PRODUCT_PER_PAGE)
    //     .skip(
    //         searchParams?.page
    //             ? parseInt(searchParams.page) * (limit || PRODUCT_PER_PAGE)
    //             : 0
    //     );
    // .find();

    // if (searchParams?.sort) {
    //     const [sortType, sortBy] = searchParams.sort.split(" ");

    //     if (sortType === "asc") {
    //         productQuery.ascending(sortBy);
    //     }
    //     if (sortType === "desc") {
    //         productQuery.descending(sortBy);
    //     }
    // }

    // const res = await productQuery.find();
    const products: any[] = [1, 2, 3, 4];

    return (
        <div className="mt-12 flex gap-x-8 gap-y-16 justify-between flex-wrap">
            {products.map((index: number) => (
                <Link
                    href={"/index"}
                    className="w-full flex flex-col gap-4 sm:w-[45%] lg:w-[22%]"
                    key={index}
                >
                    <div className="relative w-full h-80">
                        <Image
                            src={"https://images.pexels.com/photos/1183266/pexels-photo-1183266.jpeg?auto=compress&cs=tinysrgb&w=800"}
                            alt=""
                            fill
                            sizes="25vw"
                            className="absolute object-cover rounded-md z-10 hover:opacity-0 transition-opacity easy duration-500"
                        />
                        {true && (
                            <Image
                                src={"https://images.pexels.com/photos/1021693/pexels-photo-1021693.jpeg?auto=compress&cs=tinysrgb&w=800"}
                                alt=""
                                fill
                                sizes="25vw"
                                className="absolute object-cover rounded-md"
                            />
                        )}
                    </div>
                    <div className="flex justify-between">
                        <span className="font-medium">produc-name</span>
                        <span className="font-semibold">price</span>
                    </div>
                    {true && (
                        <div
                            className="text-sm text-gray-500"

                        >shortDesc</div>
                    )}
                    <button className="rounded-2xl ring-1 ring-lama text-lama w-max py-2 px-4 text-xs hover:bg-lama hover:text-white">
                        Add to Cart
                    </button>
                </Link>
            ))}
            {/* {searchParams?.cat || searchParams?.name ? (
                <Pagination
                    currentPage={res.currentPage || 0}
                    hasPrev={res.hasPrev()}
                    hasNext={res.hasNext()}
                />
            ) : null} */}


        </div>
    );
};

export default ProductList;